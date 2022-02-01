package com.tencent.av.wtogether.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.search.util.BaseSearchUtil;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;
import com.tencent.mobileqq.troop.utils.RollangleImageView;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.troop.widget.PinnedHeaderIphoneTreeView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class GroupFileSearchExpandableListAdapter
  extends BaseExpandableListAdapter
  implements Handler.Callback, View.OnClickListener, AbsListView.OnScrollListener
{
  protected static String a = "GroupFileSearchExpandableListAdapter";
  protected final int b;
  protected Activity c;
  protected QQAppInterface d;
  protected Handler e;
  protected Handler f;
  protected LayoutInflater g;
  protected PinnedHeaderIphoneTreeView h;
  protected long i;
  protected String j = null;
  protected HashMap<TroopFileSearchItemData, GroupFileSearchExpandableListAdapter.ViewHolder> k = new HashMap();
  protected List<TroopFileSearchItemData> l;
  protected List<TroopFileSearchItemData> m;
  protected GroupFileSearchExpandableListAdapter.FileSelectListener n;
  public boolean o = false;
  public boolean p = false;
  private UUID q;
  
  public GroupFileSearchExpandableListAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, long paramLong, PinnedHeaderIphoneTreeView paramPinnedHeaderIphoneTreeView, Handler paramHandler, GroupFileSearchExpandableListAdapter.FileSelectListener paramFileSelectListener)
  {
    this.c = paramActivity;
    this.d = paramQQAppInterface;
    this.i = paramLong;
    this.f = new Handler(this);
    this.g = LayoutInflater.from(paramActivity);
    this.h = paramPinnedHeaderIphoneTreeView;
    this.e = paramHandler;
    this.n = paramFileSelectListener;
    this.b = paramActivity.getResources().getDimensionPixelSize(2131298727);
    this.l = new ArrayList();
    this.m = new ArrayList();
  }
  
  private SpannableStringBuilder a(String paramString1, String paramString2, TextView paramTextView, String paramString3, String paramString4)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramString1).append("  ");
    if (!TextUtils.isEmpty(paramString2)) {
      localSpannableStringBuilder.append(BaseSearchUtil.a(paramTextView, paramString3, paramString2, true)).append("  ");
    } else {
      localSpannableStringBuilder.append(paramString3).append("  ");
    }
    localSpannableStringBuilder.append(paramString4);
    return localSpannableStringBuilder;
  }
  
  private void a(EllipsizingTextView paramEllipsizingTextView, TroopFileInfo paramTroopFileInfo, String paramString)
  {
    paramEllipsizingTextView.setText(paramTroopFileInfo.d);
    paramEllipsizingTextView.setMaxLines(1);
    if (TextUtils.isEmpty(paramString))
    {
      paramEllipsizingTextView.setText(paramTroopFileInfo.d);
      return;
    }
    paramEllipsizingTextView.a();
    if (paramEllipsizingTextView.getWidth() > 0)
    {
      paramTroopFileInfo = BaseSearchUtil.a(paramEllipsizingTextView, paramTroopFileInfo.d, paramString, true);
      paramEllipsizingTextView.setText("");
      paramEllipsizingTextView.setText(paramTroopFileInfo);
      return;
    }
    paramEllipsizingTextView.post(new GroupFileSearchExpandableListAdapter.1(this, paramEllipsizingTextView, paramTroopFileInfo, paramString));
  }
  
  private void a(boolean paramBoolean, TroopFileInfo paramTroopFileInfo, AsyncImageView paramAsyncImageView, TroopFileSearchItemData paramTroopFileSearchItemData)
  {
    if (!paramBoolean)
    {
      if (FileUtils.fileExistsAndNotEmpty(paramTroopFileInfo.w))
      {
        int i1 = FileManagerUtil.c(paramTroopFileInfo.d);
        FileManagerUtil.a(paramAsyncImageView, paramTroopFileInfo.w, i1);
        return;
      }
      paramAsyncImageView.setDefaultImage(FileManagerUtil.i(paramTroopFileInfo.d));
      TroopFileTransferManager.a(this.d, paramTroopFileSearchItemData.a).a(paramTroopFileInfo.c, paramTroopFileInfo.d, paramTroopFileInfo.f, 128);
    }
  }
  
  public TroopFileSearchItemData a(String paramString)
  {
    Object localObject = this.l;
    int i2 = 0;
    int i1;
    if (localObject != null)
    {
      i1 = 0;
      while (i1 < this.l.size())
      {
        localObject = (TroopFileSearchItemData)this.l.get(i1);
        if ((localObject != null) && (((TroopFileSearchItemData)localObject).i != null) && (((TroopFileSearchItemData)localObject).i.c.equals(paramString))) {
          return localObject;
        }
        i1 += 1;
      }
    }
    if (this.m != null)
    {
      i1 = i2;
      while (i1 < this.m.size())
      {
        localObject = (TroopFileSearchItemData)this.m.get(i1);
        if ((localObject != null) && (((TroopFileSearchItemData)localObject).i != null) && (((TroopFileSearchItemData)localObject).i.c.equals(paramString))) {
          return localObject;
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  public void a()
  {
    List localList = this.l;
    if (localList != null) {
      localList.clear();
    }
    localList = this.m;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, AsyncImageView paramAsyncImageView, long paramLong, TroopFileInfo paramTroopFileInfo)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramTroopFileInfo.w))
    {
      int i1 = FileManagerUtil.c(paramTroopFileInfo.d);
      FileManagerUtil.a(paramAsyncImageView, paramTroopFileInfo.w, i1);
      return;
    }
    paramAsyncImageView.setDefaultImage(FileManagerUtil.i(paramTroopFileInfo.d));
  }
  
  public void a(List<TroopFileSearchItemData> paramList, String paramString)
  {
    this.j = paramString;
    if ((paramList != null) && (paramList.size() != 0))
    {
      int i2 = paramList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        paramString = (TroopFileSearchItemData)paramList.get(i1);
        if (paramString.a == this.i) {
          this.l.add(paramString);
        } else {
          this.m.add(paramString);
        }
        i1 += 1;
      }
      this.e.sendEmptyMessage(4);
      return;
    }
    a();
    this.e.sendEmptyMessage(3);
  }
  
  public void b()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.l = null;
    }
    localObject = this.m;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.m = null;
    }
    localObject = this.k;
    if (localObject != null)
    {
      ((HashMap)localObject).clear();
      this.k = null;
    }
  }
  
  public void c()
  {
    int i1 = this.h.getFirstVisiblePosition();
    int i2 = this.h.getLastVisiblePosition();
    while (i1 <= i2)
    {
      long l1 = this.h.getExpandableListPosition(i1);
      if (ExpandableListView.getPackedPositionType(l1) == 1)
      {
        int i3 = ExpandableListView.getPackedPositionGroup(l1);
        int i4 = ExpandableListView.getPackedPositionChild(l1);
        if ((i3 >= 0) && (i3 < getGroupCount()) && ((getChild(i3, i4) instanceof TroopFileSearchItemData)))
        {
          TroopFileSearchItemData localTroopFileSearchItemData = (TroopFileSearchItemData)getChild(i3, i4);
          GroupFileSearchExpandableListAdapter.ViewHolder localViewHolder = (GroupFileSearchExpandableListAdapter.ViewHolder)this.k.get(localTroopFileSearchItemData);
          if (localTroopFileSearchItemData != null) {
            a(this.d, localViewHolder.c, localTroopFileSearchItemData.a, localTroopFileSearchItemData.i);
          }
        }
      }
      i1 += 1;
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt1 >= 0)
    {
      if (paramInt1 >= getGroupCount()) {
        return null;
      }
      if (paramInt1 == 0)
      {
        localObject1 = localObject2;
        if (paramInt2 >= 0)
        {
          localObject1 = localObject2;
          if (paramInt2 < getChildrenCount(0)) {
            return this.l.get(paramInt2);
          }
        }
      }
      else
      {
        localObject1 = localObject2;
        if (paramInt1 == 1)
        {
          localObject1 = localObject2;
          if (paramInt2 >= 0)
          {
            localObject1 = localObject2;
            if (paramInt2 < getChildrenCount(1)) {
              localObject1 = this.m.get(paramInt2);
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt1 == 0) && (TroopUtils.a(this.l)))
    {
      paramView = LayoutInflater.from(this.c).inflate(2131625922, null);
      ((TextView)paramView.findViewById(2131448422)).setText(this.c.getString(2131895131, new Object[] { this.j }));
      return paramView;
    }
    TroopFileSearchItemData localTroopFileSearchItemData = (TroopFileSearchItemData)getChild(paramInt1, paramInt2);
    if (localTroopFileSearchItemData == null) {
      return null;
    }
    if (paramView == null)
    {
      paramView = this.g.inflate(2013396996, paramViewGroup, false);
      paramViewGroup = new GroupFileSearchExpandableListAdapter.ViewHolder(this, paramView, this);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      Object localObject = paramView.getTag();
      if ((localObject instanceof GroupFileSearchExpandableListAdapter.ViewHolder))
      {
        paramViewGroup = (GroupFileSearchExpandableListAdapter.ViewHolder)localObject;
      }
      else
      {
        paramView = this.g.inflate(2013396996, paramViewGroup, false);
        paramViewGroup = new GroupFileSearchExpandableListAdapter.ViewHolder(this, paramView, this);
        paramView.setTag(paramViewGroup);
      }
    }
    this.k.put(localTroopFileSearchItemData, paramViewGroup);
    paramViewGroup.a(localTroopFileSearchItemData, paramInt1, this.o);
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (paramInt == 0)
    {
      if (!TroopUtils.a(this.l)) {
        return this.l.size();
      }
    }
    else if (!TroopUtils.a(this.m)) {
      return this.m.size();
    }
    return 1;
  }
  
  public Object getGroup(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public int getGroupCount()
  {
    if ((TroopUtils.a(this.l)) && (TroopUtils.a(this.m))) {
      return 0;
    }
    if (TroopUtils.a(this.m)) {
      return 1;
    }
    return 2;
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.g.inflate(2131625920, null);
    }
    paramView = (TextView)paramViewGroup.findViewById(2131434435);
    if (paramInt == 0)
    {
      paramView.setVisibility(8);
    }
    else
    {
      paramView.setVisibility(0);
      paramView.setText(2131895132);
    }
    paramViewGroup.setFocusable(true);
    this.h.expandGroup(paramInt);
    return paramViewGroup;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    if (this.p)
    {
      this.o = false;
      RollangleImageView.setSuspendLoad(false);
      c();
    }
    return true;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2013331475)
    {
      paramView = paramView.getTag(2131441532);
      if ((paramView instanceof TroopFileSearchItemData))
      {
        TroopFileSearchItemData localTroopFileSearchItemData = (TroopFileSearchItemData)paramView;
        Object localObject = localTroopFileSearchItemData.i.b;
        paramView = (View)localObject;
        if (((UUID)localObject).equals(this.q)) {
          paramView = null;
        }
        this.q = paramView;
        notifyDataSetChanged();
        localObject = this.n;
        if (localObject != null)
        {
          if (this.q != null) {
            paramView = localTroopFileSearchItemData;
          } else {
            paramView = null;
          }
          ((GroupFileSearchExpandableListAdapter.FileSelectListener)localObject).a(paramView);
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.p = true;
      this.f.sendEmptyMessageDelayed(1, 1000L);
      c();
      return;
    }
    this.p = false;
    RollangleImageView.setSuspendLoad(true);
    this.o = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.GroupFileSearchExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */