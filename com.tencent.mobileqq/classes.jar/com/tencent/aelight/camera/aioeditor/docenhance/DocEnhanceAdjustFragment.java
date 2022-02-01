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
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aebase.fragment.AEFullScreenPublicFragment;
import com.tencent.aelight.camera.aioeditor.docenhance.widget.EdgeAdjustView;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForMultiProcess;
import java.util.Arrays;

public class DocEnhanceAdjustFragment
  extends AEFullScreenPublicFragment
  implements View.OnClickListener
{
  float[] a = new float[8];
  private TextView b;
  private TextView c;
  private EdgeAdjustView d;
  private Bitmap e;
  private float[] f;
  private GYAIDocEnhance g = new GYAIDocEnhance();
  
  private void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("RESULT_ADJUST_POINTS_ARRAY", this.d.getAdjustPoints());
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
    paramActivity.overridePendingTransition(2130772014, 2130772007);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2063991523)
    {
      if (i != 2063991537) {
        return;
      }
      a();
      AEBaseDataReporter.a().u("完成");
      return;
    }
    onBackEvent();
    AEBaseDataReporter.a().u("取消");
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      String str = paramBundle.getString("ARG_RAW_PIC_PATH");
      if (!TextUtils.isEmpty(str)) {
        this.e = BitmapFactory.decodeFile(str);
      }
      paramBundle = paramBundle.getFloatArray("ARG_ADJUST_POINTS_ARRAY");
      if ((paramBundle != null) && (paramBundle.length == 8))
      {
        this.f = Arrays.copyOf(paramBundle, 8);
        return;
      }
      this.f = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2064056433, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Bitmap localBitmap = this.e;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.e = null;
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    this.b = ((TextView)paramView.findViewById(2063991523));
    this.c = ((TextView)paramView.findViewById(2063991537));
    this.d = ((EdgeAdjustView)paramView.findViewById(2063991020));
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setBitmap(this.e);
    this.d.setAdjustPoints(this.f);
    this.d.setInteractionListener(new DocEnhanceAdjustFragment.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.docenhance.DocEnhanceAdjustFragment
 * JD-Core Version:    0.7.0.1
 */