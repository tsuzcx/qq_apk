package com.tencent.aelight.camera.aioeditor.docenhance;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.gyailib.library.GYAIDocEnhance;
import com.tencent.aelight.camera.aebase.fragment.AEFullScreenPublicFragment;
import com.tencent.aelight.camera.aioeditor.docenhance.widget.EdgeAdjustView;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForMultiProcess;
import java.util.Arrays;

public class DocEnhanceAdjustFragment
  extends AEFullScreenPublicFragment
  implements View.OnClickListener
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GYAIDocEnhance jdField_a_of_type_ComGyailibLibraryGYAIDocEnhance = new GYAIDocEnhance();
  private EdgeAdjustView jdField_a_of_type_ComTencentAelightCameraAioeditorDocenhanceWidgetEdgeAdjustView;
  float[] jdField_a_of_type_ArrayOfFloat = new float[8];
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private float[] jdField_b_of_type_ArrayOfFloat;
  
  private void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("RESULT_ADJUST_POINTS_ARRAY", this.jdField_a_of_type_ComTencentAelightCameraAioeditorDocenhanceWidgetEdgeAdjustView.a());
      localFragmentActivity.setResult(-1, localIntent);
      localFragmentActivity.finish();
    }
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString, float[] paramArrayOfFloat)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ARG_RAW_PIC_PATH", paramString);
    localIntent.putExtra("ARG_ADJUST_POINTS_ARRAY", paramArrayOfFloat);
    QPublicFragmentActivityForMultiProcess.a(paramActivity, localIntent, DocEnhanceAdjustFragment.class, paramInt);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(2130772011, 2130772004);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2064122749)
    {
      if (i != 2064122762) {
        return;
      }
      a();
      return;
    }
    onBackEvent();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      String str = paramBundle.getString("ARG_RAW_PIC_PATH");
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(str);
      }
      paramBundle = paramBundle.getFloatArray("ARG_ADJUST_POINTS_ARRAY");
      if ((paramBundle != null) && (paramBundle.length == 8))
      {
        this.jdField_b_of_type_ArrayOfFloat = Arrays.copyOf(paramBundle, 8);
        return;
      }
      this.jdField_b_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2064318561, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122749));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122762));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorDocenhanceWidgetEdgeAdjustView = ((EdgeAdjustView)paramView.findViewById(2064122130));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorDocenhanceWidgetEdgeAdjustView.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorDocenhanceWidgetEdgeAdjustView.setAdjustPoints(this.jdField_b_of_type_ArrayOfFloat);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorDocenhanceWidgetEdgeAdjustView.setInteractionListener(new DocEnhanceAdjustFragment.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.docenhance.DocEnhanceAdjustFragment
 * JD-Core Version:    0.7.0.1
 */