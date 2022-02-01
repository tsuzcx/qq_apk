package com.tencent.av.wtogether.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.wtogether.callback.C2CFileClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class QVideoC2CFileExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new QVideoC2CFileExpandableListAdapter.1(this);
  private C2CFileClickListener jdField_a_of_type_ComTencentAvWtogetherCallbackC2CFileClickListener;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<Integer, ArrayList<QVideoC2CFileExpandableListAdapter.PosInfo>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public QVideoC2CFileExpandableListAdapter(Context paramContext, LinkedHashMap<String, List<FileManagerEntity>> paramLinkedHashMap, C2CFileClickListener paramC2CFileClickListener)
  {
    super(paramContext, paramLinkedHashMap);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentAvWtogetherCallbackC2CFileClickListener = paramC2CFileClickListener;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = ((ArrayList)localObject1).iterator();
      localObject1 = null;
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2 = (QVideoC2CFileExpandableListAdapter.PosInfo)((Iterator)localObject3).next();
        if (((QVideoC2CFileExpandableListAdapter.PosInfo)localObject2).jdField_a_of_type_Int == paramInt2) {
          localObject1 = (FileManagerEntity)getChild(paramInt1, ((QVideoC2CFileExpandableListAdapter.PosInfo)localObject2).jdField_b_of_type_Int);
        }
      }
    }
    Object localObject2 = null;
    if (localObject2 == null) {
      return paramView;
    }
    if (paramView == null) {
      localObject1 = paramView;
    }
    try
    {
      localObject3 = new QVideoC2CFileExpandableListAdapter.RecentItemHolder();
      localObject1 = paramView;
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560778, paramViewGroup, false);
      localObject1 = paramView;
      ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376167));
      localObject1 = paramView;
      ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject3);
      localObject1 = paramView;
      ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370701);
      localObject1 = paramView;
      ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131366794));
      localObject1 = paramView;
      ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366781));
      localObject1 = paramView;
      ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localObject3);
      localObject1 = paramView;
      ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366792));
      localObject1 = paramView;
      ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetTextView.setGravity(48);
      localObject1 = paramView;
      ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      localObject1 = paramView;
      ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject3).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366779));
      localObject1 = paramView;
      ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject3).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(AIOUtils.b(70.0F, this.b.getResources()), AIOUtils.b(70.0F, this.b.getResources()));
      localObject1 = paramView;
      paramView.setTag(localObject3);
      paramViewGroup = (ViewGroup)localObject3;
      break label365;
      localObject1 = paramView;
      paramViewGroup = (QVideoC2CFileExpandableListAdapter.RecentItemHolder)paramView.getTag();
      label365:
      localObject1 = paramView;
      FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, ((FileManagerEntity)localObject2).strThumbPath, 2);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_Int = paramInt1;
      localObject1 = paramView;
      paramViewGroup.jdField_b_of_type_Int = paramInt2;
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localObject1 = paramView;
      if (QQFileManagerUtil.a(this.b, (FileManagerEntity)localObject2))
      {
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
      }
      else
      {
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject2;
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((FileManagerEntity)localObject2).fileName);
      localObject1 = paramView;
      if (5 != ((FileManagerEntity)localObject2).cloudType)
      {
        localObject1 = paramView;
        FileManagerUtil.b((FileManagerEntity)localObject2);
      }
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(((FileManagerEntity)localObject2).Uuid.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString));
      localObject1 = paramView;
      if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackC2CFileClickListener != null)
      {
        localObject1 = paramView;
        if (((FileManagerEntity)localObject2).Uuid.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
        {
          localObject1 = paramView;
          this.jdField_a_of_type_ComTencentAvWtogetherCallbackC2CFileClickListener.a(true);
        }
      }
      localObject1 = paramView;
      localObject3 = (LinearLayout.LayoutParams)paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      localObject1 = paramView;
      ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(3.0F, this.b.getResources());
      localObject1 = paramView;
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.b.getResources().getDisplayMetrics()), 1.0F);
      localObject1 = paramView;
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.b.getResources().getDisplayMetrics()), 1.0F);
      localObject1 = paramView;
      FileManagerUtil.a(paramViewGroup.jdField_b_of_type_AndroidWidgetTextView, (FileManagerEntity)localObject2);
      return paramView;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
    return localObject1;
  }
  
  public int getChildrenCount(int paramInt)
  {
    Object localObject1 = a(paramInt);
    int j = 0;
    if (localObject1 != null)
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new ArrayList());
      }
      localObject1 = (ArrayList)localObject1;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject2 = (FileManagerEntity)localIterator.next();
        if ((((FileManagerEntity)localObject2).getCloudType() != 0) && ((((FileManagerEntity)localObject2).getCloudType() != 5) || (((FileManagerEntity)localObject2).bSend) || (((FileManagerEntity)localObject2).status == 1)) && (!((FileManagerEntity)localObject2).sendCloudUnsuccessful()))
        {
          localObject2 = new QVideoC2CFileExpandableListAdapter.PosInfo();
          ((QVideoC2CFileExpandableListAdapter.PosInfo)localObject2).jdField_a_of_type_Int = i;
          ((QVideoC2CFileExpandableListAdapter.PosInfo)localObject2).jdField_b_of_type_Int = (i + j);
          localArrayList.add(localObject2);
          i += 1;
        }
        else
        {
          j += 1;
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localArrayList);
      return ((ArrayList)localObject1).size() - j;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.QVideoC2CFileExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */