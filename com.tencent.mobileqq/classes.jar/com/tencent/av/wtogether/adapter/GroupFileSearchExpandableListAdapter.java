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
  protected final int a;
  protected long a;
  protected Activity a;
  protected Handler a;
  protected LayoutInflater a;
  protected GroupFileSearchExpandableListAdapter.FileSelectListener a;
  protected QQAppInterface a;
  protected PinnedHeaderIphoneTreeView a;
  protected HashMap<TroopFileSearchItemData, GroupFileSearchExpandableListAdapter.ViewHolder> a;
  protected List<TroopFileSearchItemData> a;
  private UUID a;
  public boolean a;
  protected Handler b;
  protected String b;
  protected List<TroopFileSearchItemData> b;
  public boolean b;
  
  public GroupFileSearchExpandableListAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, long paramLong, PinnedHeaderIphoneTreeView paramPinnedHeaderIphoneTreeView, Handler paramHandler, GroupFileSearchExpandableListAdapter.FileSelectListener paramFileSelectListener)
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView = paramPinnedHeaderIphoneTreeView;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter$FileSelectListener = paramFileSelectListener;
    this.jdField_a_of_type_Int = paramActivity.getResources().getDimensionPixelSize(2131298051);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
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
    paramEllipsizingTextView.setText(paramTroopFileInfo.c);
    paramEllipsizingTextView.setMaxLines(1);
    if (TextUtils.isEmpty(paramString))
    {
      paramEllipsizingTextView.setText(paramTroopFileInfo.c);
      return;
    }
    paramEllipsizingTextView.a();
    if (paramEllipsizingTextView.getWidth() > 0)
    {
      paramTroopFileInfo = BaseSearchUtil.a(paramEllipsizingTextView, paramTroopFileInfo.c, paramString, true);
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
      if (FileUtils.fileExistsAndNotEmpty(paramTroopFileInfo.j))
      {
        int i = FileManagerUtil.a(paramTroopFileInfo.c);
        FileManagerUtil.a(paramAsyncImageView, paramTroopFileInfo.j, i);
        return;
      }
      paramAsyncImageView.setDefaultImage(FileManagerUtil.b(paramTroopFileInfo.c));
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopFileSearchItemData.jdField_a_of_type_Long).a(paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo.c, paramTroopFileInfo.jdField_a_of_type_Int, 128);
    }
  }
  
  public TroopFileSearchItemData a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    int j = 0;
    int i;
    if (localObject != null)
    {
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (TroopFileSearchItemData)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localObject != null) && (((TroopFileSearchItemData)localObject).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo != null) && (((TroopFileSearchItemData)localObject).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_b_of_type_JavaLangString.equals(paramString))) {
          return localObject;
        }
        i += 1;
      }
    }
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      i = j;
      while (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        localObject = (TroopFileSearchItemData)this.jdField_b_of_type_JavaUtilList.get(i);
        if ((localObject != null) && (((TroopFileSearchItemData)localObject).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo != null) && (((TroopFileSearchItemData)localObject).jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_b_of_type_JavaLangString.equals(paramString))) {
          return localObject;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public void a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      localList.clear();
    }
    localList = this.jdField_b_of_type_JavaUtilList;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, AsyncImageView paramAsyncImageView, long paramLong, TroopFileInfo paramTroopFileInfo)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramTroopFileInfo.j))
    {
      int i = FileManagerUtil.a(paramTroopFileInfo.c);
      FileManagerUtil.a(paramAsyncImageView, paramTroopFileInfo.j, i);
      return;
    }
    paramAsyncImageView.setDefaultImage(FileManagerUtil.b(paramTroopFileInfo.c));
  }
  
  public void a(List<TroopFileSearchItemData> paramList, String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if ((paramList != null) && (paramList.size() != 0))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        paramString = (TroopFileSearchItemData)paramList.get(i);
        if (paramString.jdField_a_of_type_Long == this.jdField_a_of_type_Long) {
          this.jdField_a_of_type_JavaUtilList.add(paramString);
        } else {
          this.jdField_b_of_type_JavaUtilList.add(paramString);
        }
        i += 1;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      return;
    }
    a();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    localObject = this.jdField_b_of_type_JavaUtilList;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.jdField_b_of_type_JavaUtilList = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      ((HashMap)localObject).clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
  }
  
  public void c()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.getLastVisiblePosition();
    while (i <= j)
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.getExpandableListPosition(i);
      if (ExpandableListView.getPackedPositionType(l) == 1)
      {
        int k = ExpandableListView.getPackedPositionGroup(l);
        int m = ExpandableListView.getPackedPositionChild(l);
        if ((k >= 0) && (k < getGroupCount()) && ((getChild(k, m) instanceof TroopFileSearchItemData)))
        {
          TroopFileSearchItemData localTroopFileSearchItemData = (TroopFileSearchItemData)getChild(k, m);
          GroupFileSearchExpandableListAdapter.ViewHolder localViewHolder = (GroupFileSearchExpandableListAdapter.ViewHolder)this.jdField_a_of_type_JavaUtilHashMap.get(localTroopFileSearchItemData);
          if (localTroopFileSearchItemData != null) {
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localViewHolder.a, localTroopFileSearchItemData.jdField_a_of_type_Long, localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo);
          }
        }
      }
      i += 1;
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
            return this.jdField_a_of_type_JavaUtilList.get(paramInt2);
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
              localObject1 = this.jdField_b_of_type_JavaUtilList.get(paramInt2);
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
    if ((paramInt1 == 0) && (TroopUtils.a(this.jdField_a_of_type_JavaUtilList)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131559879, null);
      ((TextView)paramView.findViewById(2131379650)).setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131697358, new Object[] { this.jdField_b_of_type_JavaLangString }));
      return paramView;
    }
    TroopFileSearchItemData localTroopFileSearchItemData = (TroopFileSearchItemData)getChild(paramInt1, paramInt2);
    if (localTroopFileSearchItemData == null) {
      return null;
    }
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2013396996, paramViewGroup, false);
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
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2013396996, paramViewGroup, false);
        paramViewGroup = new GroupFileSearchExpandableListAdapter.ViewHolder(this, paramView, this);
        paramView.setTag(paramViewGroup);
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(localTroopFileSearchItemData, paramViewGroup);
    paramViewGroup.a(localTroopFileSearchItemData, paramInt1, this.jdField_a_of_type_Boolean);
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (paramInt == 0)
    {
      if (!TroopUtils.a(this.jdField_a_of_type_JavaUtilList)) {
        return this.jdField_a_of_type_JavaUtilList.size();
      }
    }
    else if (!TroopUtils.a(this.jdField_b_of_type_JavaUtilList)) {
      return this.jdField_b_of_type_JavaUtilList.size();
    }
    return 1;
  }
  
  public Object getGroup(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public int getGroupCount()
  {
    if ((TroopUtils.a(this.jdField_a_of_type_JavaUtilList)) && (TroopUtils.a(this.jdField_b_of_type_JavaUtilList))) {
      return 0;
    }
    if (TroopUtils.a(this.jdField_b_of_type_JavaUtilList)) {
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
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559877, null);
    }
    paramView = (TextView)paramViewGroup.findViewById(2131367855);
    if (paramInt == 0)
    {
      paramView.setVisibility(8);
    }
    else
    {
      paramView.setVisibility(0);
      paramView.setText(2131697359);
    }
    paramViewGroup.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.expandGroup(paramInt);
    return paramViewGroup;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
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
      paramView = paramView.getTag(2131373858);
      if ((paramView instanceof TroopFileSearchItemData))
      {
        TroopFileSearchItemData localTroopFileSearchItemData = (TroopFileSearchItemData)paramView;
        Object localObject = localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_a_of_type_JavaUtilUUID;
        paramView = (View)localObject;
        if (((UUID)localObject).equals(this.jdField_a_of_type_JavaUtilUUID)) {
          paramView = null;
        }
        this.jdField_a_of_type_JavaUtilUUID = paramView;
        notifyDataSetChanged();
        localObject = this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter$FileSelectListener;
        if (localObject != null)
        {
          if (this.jdField_a_of_type_JavaUtilUUID != null) {
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
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      c();
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    RollangleImageView.setSuspendLoad(true);
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.GroupFileSearchExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */