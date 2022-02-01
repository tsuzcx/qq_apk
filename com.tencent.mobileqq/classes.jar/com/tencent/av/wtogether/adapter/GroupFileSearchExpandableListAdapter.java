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
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;
import com.tencent.mobileqq.troop.utils.RollangleImageView;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.troop.widget.PinnedHeaderIphoneTreeView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  protected static String a;
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
  
  static
  {
    jdField_a_of_type_JavaLangString = "GroupFileSearchExpandableListAdapter";
  }
  
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
    this.jdField_a_of_type_Int = paramActivity.getResources().getDimensionPixelSize(2131298057);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private SpannableStringBuilder a(String paramString1, String paramString2, TextView paramTextView, String paramString3, String paramString4)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramString1).append("  ");
    if (!TextUtils.isEmpty(paramString2)) {
      localSpannableStringBuilder.append(SearchUtils.a(paramTextView, paramString3, paramString2, true)).append("  ");
    }
    for (;;)
    {
      localSpannableStringBuilder.append(paramString4);
      return localSpannableStringBuilder;
      localSpannableStringBuilder.append(paramString3).append("  ");
    }
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
      paramTroopFileInfo = SearchUtils.a(paramEllipsizingTextView, paramTroopFileInfo.c, paramString, true);
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
      if (FileUtils.b(paramTroopFileInfo.j))
      {
        int i = FileManagerUtil.a(paramTroopFileInfo.c);
        FileManagerUtil.a(paramAsyncImageView, paramTroopFileInfo.j, i);
      }
    }
    else {
      return;
    }
    paramAsyncImageView.setDefaultImage(FileManagerUtil.b(paramTroopFileInfo.c));
    TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopFileSearchItemData.jdField_a_of_type_Long).a(paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo.c, paramTroopFileInfo.jdField_a_of_type_Int, 128);
  }
  
  public TroopFileSearchItemData a(String paramString)
  {
    int j = 0;
    int i;
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilList != null)
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
      for (;;)
      {
        if (i >= this.jdField_b_of_type_JavaUtilList.size()) {
          break label153;
        }
        TroopFileSearchItemData localTroopFileSearchItemData = (TroopFileSearchItemData)this.jdField_b_of_type_JavaUtilList.get(i);
        if ((localTroopFileSearchItemData != null) && (localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo != null))
        {
          localObject = localTroopFileSearchItemData;
          if (localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_b_of_type_JavaLangString.equals(paramString)) {
            break;
          }
        }
        i += 1;
      }
    }
    label153:
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, AsyncImageView paramAsyncImageView, long paramLong, TroopFileInfo paramTroopFileInfo)
  {
    if (FileUtils.b(paramTroopFileInfo.j))
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
    if ((paramList == null) || (paramList.size() == 0))
    {
      a();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      paramString = (TroopFileSearchItemData)paramList.get(i);
      if (paramString.jdField_a_of_type_Long == this.jdField_a_of_type_Long) {
        this.jdField_a_of_type_JavaUtilList.add(paramString);
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_b_of_type_JavaUtilList.add(paramString);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
  }
  
  public void c()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.getLastVisiblePosition();
    if (i <= j)
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.getExpandableListPosition(i);
      int k;
      int m;
      if (ExpandableListView.getPackedPositionType(l) == 1)
      {
        k = ExpandableListView.getPackedPositionGroup(l);
        m = ExpandableListView.getPackedPositionChild(l);
        if ((k >= 0) && (k < getGroupCount())) {
          break label72;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label72:
        if ((getChild(k, m) instanceof TroopFileSearchItemData))
        {
          TroopFileSearchItemData localTroopFileSearchItemData = (TroopFileSearchItemData)getChild(k, m);
          GroupFileSearchExpandableListAdapter.ViewHolder localViewHolder = (GroupFileSearchExpandableListAdapter.ViewHolder)this.jdField_a_of_type_JavaUtilHashMap.get(localTroopFileSearchItemData);
          if (localTroopFileSearchItemData != null) {
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localViewHolder.a, localTroopFileSearchItemData.jdField_a_of_type_Long, localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo);
          }
        }
      }
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= getGroupCount())) {}
    do
    {
      do
      {
        return null;
        if (paramInt1 != 0) {
          break;
        }
      } while ((paramInt2 < 0) || (paramInt2 >= getChildrenCount(0)));
      return this.jdField_a_of_type_JavaUtilList.get(paramInt2);
    } while ((paramInt1 != 1) || (paramInt2 < 0) || (paramInt2 >= getChildrenCount(1)));
    return this.jdField_b_of_type_JavaUtilList.get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt1 == 0) && (TroopUtils.a(this.jdField_a_of_type_JavaUtilList)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560008, null);
      ((TextView)paramView.findViewById(2131380329)).setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131697339, new Object[] { this.jdField_b_of_type_JavaLangString }));
      return paramView;
    }
    TroopFileSearchItemData localTroopFileSearchItemData = (TroopFileSearchItemData)getChild(paramInt1, paramInt2);
    if (localTroopFileSearchItemData == null) {
      return null;
    }
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559917, paramViewGroup, false);
      paramViewGroup = new GroupFileSearchExpandableListAdapter.ViewHolder(this, paramView, this);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(localTroopFileSearchItemData, paramViewGroup);
      paramViewGroup.a(localTroopFileSearchItemData, paramInt1, this.jdField_a_of_type_Boolean);
      return paramView;
      Object localObject = paramView.getTag();
      if ((localObject instanceof GroupFileSearchExpandableListAdapter.ViewHolder))
      {
        paramViewGroup = (GroupFileSearchExpandableListAdapter.ViewHolder)localObject;
      }
      else
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559917, paramViewGroup, false);
        paramViewGroup = new GroupFileSearchExpandableListAdapter.ViewHolder(this, paramView, this);
        paramView.setTag(paramViewGroup);
      }
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    int i = 1;
    if (paramInt == 0)
    {
      paramInt = i;
      if (!TroopUtils.a(this.jdField_a_of_type_JavaUtilList)) {
        paramInt = this.jdField_a_of_type_JavaUtilList.size();
      }
    }
    do
    {
      return paramInt;
      paramInt = i;
    } while (TroopUtils.a(this.jdField_b_of_type_JavaUtilList));
    return this.jdField_b_of_type_JavaUtilList.size();
  }
  
  public Object getGroup(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public int getGroupCount()
  {
    int i = 2;
    if ((TroopUtils.a(this.jdField_a_of_type_JavaUtilList)) && (TroopUtils.a(this.jdField_b_of_type_JavaUtilList))) {
      i = 0;
    }
    while (!TroopUtils.a(this.jdField_b_of_type_JavaUtilList)) {
      return i;
    }
    return 1;
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560006, null);
    }
    paramView = (TextView)paramViewGroup.findViewById(2131368102);
    if (paramInt == 0) {
      paramView.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPinnedHeaderIphoneTreeView.expandGroup(paramInt);
      return paramViewGroup;
      paramView.setVisibility(0);
      paramView.setText(2131697340);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        RollangleImageView.setSuspendLoad(false);
        c();
      }
    }
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
    switch (paramView.getId())
    {
    }
    TroopFileSearchItemData localTroopFileSearchItemData;
    do
    {
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject1 = paramView.getTag(2131374302);
      } while (!(localObject1 instanceof TroopFileSearchItemData));
      localTroopFileSearchItemData = (TroopFileSearchItemData)localObject1;
      localObject2 = localTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_a_of_type_JavaUtilUUID;
      localObject1 = localObject2;
      if (((UUID)localObject2).equals(this.jdField_a_of_type_JavaUtilUUID)) {
        localObject1 = null;
      }
      this.jdField_a_of_type_JavaUtilUUID = localObject1;
      notifyDataSetChanged();
    } while (this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter$FileSelectListener == null);
    Object localObject2 = this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter$FileSelectListener;
    if (this.jdField_a_of_type_JavaUtilUUID != null) {}
    for (Object localObject1 = localTroopFileSearchItemData;; localObject1 = null)
    {
      ((GroupFileSearchExpandableListAdapter.FileSelectListener)localObject2).a(localObject1);
      break;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.GroupFileSearchExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */