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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
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
  private QVideoC2CFileExpandableListAdapter.UIEvent jdField_a_of_type_ComTencentAvWtogetherAdapterQVideoC2CFileExpandableListAdapter$UIEvent;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<Integer, ArrayList<QVideoC2CFileExpandableListAdapter.PosInfo>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public QVideoC2CFileExpandableListAdapter(Context paramContext, LinkedHashMap<String, List<FileManagerEntity>> paramLinkedHashMap, QVideoC2CFileExpandableListAdapter.UIEvent paramUIEvent)
  {
    super(paramContext, paramLinkedHashMap);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentAvWtogetherAdapterQVideoC2CFileExpandableListAdapter$UIEvent = paramUIEvent;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    FileManagerEntity localFileManagerEntity = null;
    Object localObject2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    Object localObject3;
    if (localObject2 != null)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (QVideoC2CFileExpandableListAdapter.PosInfo)((Iterator)localObject2).next();
        if (((QVideoC2CFileExpandableListAdapter.PosInfo)localObject3).jdField_a_of_type_Int != paramInt2) {
          break label754;
        }
        localFileManagerEntity = (FileManagerEntity)getChild(paramInt1, ((QVideoC2CFileExpandableListAdapter.PosInfo)localObject3).jdField_b_of_type_Int);
      }
    }
    for (;;)
    {
      if (localFileManagerEntity == null) {
        return paramView;
      }
      if (paramView == null) {}
      for (;;)
      {
        try
        {
          localObject2 = new QVideoC2CFileExpandableListAdapter.RecentItemHolder();
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560904, paramViewGroup, false);
          paramView = paramViewGroup;
          paramViewGroup = paramView;
        }
        catch (Exception paramViewGroup)
        {
          continue;
        }
        try
        {
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376663));
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371067);
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131366932));
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366919));
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localObject2);
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366930));
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setGravity(48);
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366917));
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(AIOUtils.a(70.0F, this.b.getResources()), AIOUtils.a(70.0F, this.b.getResources()));
          paramViewGroup = paramView;
          paramView.setTag(localObject2);
          paramViewGroup = paramView;
          FileManagerUtil.a(((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity.strThumbPath, 2);
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_Int = paramInt1;
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_b_of_type_Int = paramInt2;
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          paramViewGroup = paramView;
          if (!FileManagerUtil.a(this.b, localFileManagerEntity)) {
            continue;
          }
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_JavaLangObject = localFileManagerEntity;
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(localFileManagerEntity.fileName);
          paramViewGroup = paramView;
          if (5 != localFileManagerEntity.cloudType)
          {
            paramViewGroup = paramView;
            FileManagerUtil.b(localFileManagerEntity);
          }
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localFileManagerEntity.Uuid.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString));
          paramViewGroup = paramView;
          if (this.jdField_a_of_type_ComTencentAvWtogetherAdapterQVideoC2CFileExpandableListAdapter$UIEvent != null)
          {
            paramViewGroup = paramView;
            if (localFileManagerEntity.Uuid.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
            {
              paramViewGroup = paramView;
              this.jdField_a_of_type_ComTencentAvWtogetherAdapterQVideoC2CFileExpandableListAdapter$UIEvent.a(true);
            }
          }
          paramViewGroup = paramView;
          localObject3 = (LinearLayout.LayoutParams)((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
          paramViewGroup = paramView;
          ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(3.0F, this.b.getResources());
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.b.getResources().getDisplayMetrics()), 1.0F);
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          paramViewGroup = paramView;
          ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.b.getResources().getDisplayMetrics()), 1.0F);
          paramViewGroup = paramView;
          FileManagerUtil.a(((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView, localFileManagerEntity);
        }
        catch (Exception localException)
        {
          paramView = paramViewGroup;
          paramViewGroup = localException;
          paramViewGroup.printStackTrace();
          continue;
        }
        return paramView;
        localObject2 = (QVideoC2CFileExpandableListAdapter.RecentItemHolder)paramView.getTag();
        continue;
        paramViewGroup = paramView;
        ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup = paramView;
        ((QVideoC2CFileExpandableListAdapter.RecentItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      label754:
      break;
      Object localObject1 = null;
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    int i = 0;
    Object localObject1 = a(paramInt);
    if (localObject1 != null)
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new ArrayList());
      }
      localObject1 = (ArrayList)localObject1;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      int j = 0;
      i = 0;
      if (localIterator.hasNext())
      {
        Object localObject2 = (FileManagerEntity)localIterator.next();
        int k;
        if ((((FileManagerEntity)localObject2).getCloudType() == 0) || ((((FileManagerEntity)localObject2).getCloudType() == 5) && (!((FileManagerEntity)localObject2).bSend) && (((FileManagerEntity)localObject2).status != 1)))
        {
          k = j + 1;
          j = i;
          i = k;
        }
        for (;;)
        {
          k = j;
          j = i;
          i = k;
          break;
          if (((FileManagerEntity)localObject2).sendCloudUnsuccessful())
          {
            k = j + 1;
            j = i;
            i = k;
          }
          else
          {
            localObject2 = new QVideoC2CFileExpandableListAdapter.PosInfo();
            ((QVideoC2CFileExpandableListAdapter.PosInfo)localObject2).jdField_a_of_type_Int = i;
            ((QVideoC2CFileExpandableListAdapter.PosInfo)localObject2).jdField_b_of_type_Int = (i + j);
            localArrayList.add(localObject2);
            k = i + 1;
            i = j;
            j = k;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localArrayList);
      i = ((ArrayList)localObject1).size() - j;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.QVideoC2CFileExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */