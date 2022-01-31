package com.tencent.av.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.av.AVLog;
import kdb;

public class VoiceChangeAdapter
  extends BaseAdapter
{
  public static String a;
  private static VoiceChangeData.VoiceInfo[] jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo = VoiceChangeData.a().a();
  private int jdField_a_of_type_Int = -16777216;
  private Context jdField_a_of_type_AndroidContentContext;
  private VoiceChangeAdapter.ICallback jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter$ICallback;
  VoiceChangeItemView1.ICallback jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1$ICallback = new kdb(this);
  private VoiceChangeItemView1 jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1;
  private int jdField_b_of_type_Int;
  private VoiceChangeItemView1 jdField_b_of_type_ComTencentAvUiVoiceChangeItemView1;
  private int c;
  private int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VoiceChangeAdapter";
  }
  
  public VoiceChangeAdapter(Context paramContext, int paramInt, VoiceChangeAdapter.ICallback paramICallback)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter$ICallback = paramICallback;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo == null) {
      return 0;
    }
    return jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo.length;
  }
  
  public Object getItem(int paramInt)
  {
    if (jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo == null) {
      return null;
    }
    return jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    AVLog.a(jdField_a_of_type_JavaLangString, "getView|position=" + paramInt + ", view=" + paramView);
    if (paramView == null) {
      paramView = new VoiceChangeItemView1(this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      paramViewGroup = (VoiceChangeData.VoiceInfo)getItem(paramInt);
      VoiceChangeItemView1 localVoiceChangeItemView1;
      if (paramViewGroup != null)
      {
        if ((this.d == 0) && (paramInt == 1) && (this.jdField_b_of_type_Int == 0)) {
          this.jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1 = this.jdField_b_of_type_ComTencentAvUiVoiceChangeItemView1;
        }
        localVoiceChangeItemView1 = (VoiceChangeItemView1)paramView;
        if (this.c != paramViewGroup.jdField_a_of_type_Int) {
          break label168;
        }
      }
      for (;;)
      {
        localVoiceChangeItemView1.a(paramInt, paramViewGroup, bool, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1$ICallback);
        if (this.c == paramViewGroup.jdField_a_of_type_Int)
        {
          if (paramInt != 0) {
            this.jdField_a_of_type_ComTencentAvUiVoiceChangeItemView1 = localVoiceChangeItemView1;
          }
          this.d = paramInt;
        }
        this.jdField_b_of_type_ComTencentAvUiVoiceChangeItemView1 = ((VoiceChangeItemView1)paramView);
        this.jdField_b_of_type_Int = paramInt;
        return paramView;
        label168:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeAdapter
 * JD-Core Version:    0.7.0.1
 */