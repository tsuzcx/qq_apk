package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorConfig;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorConfig.SmartTextColor;
import java.util.List;
import javax.annotation.Nonnull;

public class AEGIFTextColorAdapter
  extends RecyclerView.Adapter<AEGIFTextColorAdapter.TextEditColorViewHolder>
{
  private static List<AEGIFTextColorConfig.SmartTextColor> jdField_a_of_type_JavaUtilList;
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public AEGIFTextColorAdapter(Context paramContext, RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    a();
    this.jdField_a_of_type_JavaLangString = ((AEGIFTextColorConfig.SmartTextColor)jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_JavaLangString;
    this.b = ((AEGIFTextColorConfig.SmartTextColor)jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).b;
  }
  
  private void a()
  {
    jdField_a_of_type_JavaUtilList = AEGIFTextColorConfig.jdField_a_of_type_JavaUtilList;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NonNull
  public AEGIFTextColorAdapter.TextEditColorViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    }
    return new AEGIFTextColorAdapter.TextEditColorViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2064318602, paramViewGroup, false));
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = ((AEGIFTextColorConfig.SmartTextColor)jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString;
    this.b = ((AEGIFTextColorConfig.SmartTextColor)jdField_a_of_type_JavaUtilList.get(paramInt)).b;
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void a(@NonNull AEGIFTextColorAdapter.TextEditColorViewHolder paramTextEditColorViewHolder, int paramInt)
  {
    paramTextEditColorViewHolder.a(((AEGIFTextColorConfig.SmartTextColor)jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString);
    if (paramInt == this.jdField_a_of_type_Int) {
      paramTextEditColorViewHolder.a(true);
    } else {
      paramTextEditColorViewHolder.a(false);
    }
    paramTextEditColorViewHolder.itemView.setOnClickListener(new AEGIFTextColorAdapter.1(this, paramInt, paramTextEditColorViewHolder));
  }
  
  @Nonnull
  public String b()
  {
    return this.b;
  }
  
  public int getItemCount()
  {
    return jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFTextColorAdapter
 * JD-Core Version:    0.7.0.1
 */