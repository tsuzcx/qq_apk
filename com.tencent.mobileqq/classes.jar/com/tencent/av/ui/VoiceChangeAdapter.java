package com.tencent.av.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.av.AVLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VoiceChangeAdapter
  extends BaseAdapter
{
  public static String a;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private VoiceChangeAdapter.ICallback jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter$ICallback;
  VoiceChangeItemView1.ICallback jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1$ICallback;
  private VoiceChangeItemView1 jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1;
  private VoiceChangeData.VoiceInfo[] jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo;
  private int jdField_b_of_type_Int;
  private VoiceChangeItemView1 jdField_b_of_type_ComTencentAvUiVoiceChangeItemView1;
  private int c;
  private int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VoiceChangeAdapter";
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(VoiceChangeData.VoiceInfo[] paramArrayOfVoiceInfo)
  {
    this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo = paramArrayOfVoiceInfo;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo == null) {
      return 0;
    }
    return this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo.length;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo == null) {
      return null;
    }
    return this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    AVLog.printDebugLog(jdField_a_of_type_JavaLangString, "getView|position=" + paramInt + ", view=" + paramView);
    if (paramView == null) {
      paramView = new VoiceChangeItemView1(this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      VoiceChangeData.VoiceInfo localVoiceInfo = (VoiceChangeData.VoiceInfo)getItem(paramInt);
      VoiceChangeItemView1 localVoiceChangeItemView1;
      if (localVoiceInfo != null)
      {
        if ((this.d == 0) && (paramInt == 1) && (this.jdField_b_of_type_Int == 0)) {
          this.jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1 = this.jdField_b_of_type_ComTencentAvUiVoiceChangeItemView1;
        }
        localVoiceChangeItemView1 = (VoiceChangeItemView1)paramView;
        if (this.c != localVoiceInfo.jdField_a_of_type_Int) {
          break label187;
        }
      }
      for (;;)
      {
        localVoiceChangeItemView1.a(paramInt, localVoiceInfo, bool, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1$ICallback);
        if (this.c == localVoiceInfo.jdField_a_of_type_Int)
        {
          if (paramInt != 0) {
            this.jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1 = localVoiceChangeItemView1;
          }
          this.d = paramInt;
        }
        this.jdField_b_of_type_ComTencentAvUiVoiceChangeItemView1 = ((VoiceChangeItemView1)paramView);
        this.jdField_b_of_type_Int = paramInt;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label187:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeAdapter
 * JD-Core Version:    0.7.0.1
 */