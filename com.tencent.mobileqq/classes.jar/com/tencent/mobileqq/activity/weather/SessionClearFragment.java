package com.tencent.mobileqq.activity.weather;

import abtr;
import aejb;
import aejc;
import aikh;
import aiki;
import aikj;
import aikk;
import aikl;
import aikm;
import aikp;
import aikq;
import aiks;
import ajya;
import akrl;
import akrt;
import alxf;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anoz;
import bbdx;
import bbef;
import bcqf;
import bcql;
import bjal;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SessionClearFragment
  extends PublicBaseFragment
  implements abtr
{
  private int jdField_a_of_type_Int = 0;
  private aejb jdField_a_of_type_Aejb;
  private aiks jdField_a_of_type_Aiks;
  private akrt jdField_a_of_type_Akrt;
  private alxf jdField_a_of_type_Alxf;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private SparseArray<URLDrawable> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcqf jdField_a_of_type_Bcqf;
  private PeakAppInterface jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface;
  List<akrl> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private alxf jdField_b_of_type_Alxf;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private int jdField_c_of_type_Int;
  private alxf jdField_c_of_type_Alxf;
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    anoz localanoz = new anoz(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localanoz, localanoz);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SessionClearFragment", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString, localException);
        }
      }
    }
    return localanoz;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajya.a(2131713862));
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajya.a(2131713850));
    }
  }
  
  private void a(Dialog paramDialog)
  {
    if ((paramDialog != null) && (this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SessionClearFragment", 2, "showDialogSafe exception: " + paramDialog.getMessage());
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131375919));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131375790));
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376343));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131364995));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363375));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getActivity());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131365638));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Aiks = new aiks(this, new ArrayList());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aiks);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aikl(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new aikm(this));
    paramView.findViewById(2131364268).setOnClickListener(new aikp(this));
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (bbdx.b(paramString))
    {
      paramString = ShortVideoUtils.a(paramString);
      if (paramString != null)
      {
        paramString = a(paramString.toString(), paramInt1, paramInt2);
        if ((paramString instanceof URLDrawable)) {
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt3, (URLDrawable)paramString);
        }
        paramImageView.setImageDrawable(paramString);
      }
    }
    else
    {
      return;
    }
    QLog.d("SessionClearFragment", 2, "url  is null ");
  }
  
  private void c()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    if (i < this.jdField_a_of_type_Aiks.getItemCount())
    {
      if (this.jdField_a_of_type_Aiks.a(i).a) {
        localArrayList1.add(this.jdField_a_of_type_Aiks.a(i));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList2.add(this.jdField_a_of_type_Aiks.a(i));
      }
    }
    if (localArrayList1.size() > 0)
    {
      this.jdField_a_of_type_Akrt.a(localArrayList1);
      if ((localArrayList2 != null) && (localArrayList2.size() != 0)) {
        break label149;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    for (;;)
    {
      bcql.a(this.jdField_a_of_type_AndroidAppActivity, 2, 2131691514, 0).b(getResources().getDimensionPixelSize(2131298865));
      return;
      label149:
      this.jdField_a_of_type_Aiks.a(localArrayList2);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      a(0);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bcqf == null) {
      this.jdField_a_of_type_Bcqf = new bcqf(this.jdField_a_of_type_AndroidAppActivity, getResources().getDimensionPixelSize(2131298865));
    }
    this.jdField_a_of_type_Bcqf.setCancelable(false);
    this.jdField_a_of_type_Bcqf.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bcqf.a(ajya.a(2131713857));
    this.jdField_a_of_type_Bcqf.show();
    this.jdField_a_of_type_Bcqf.a(new aikq(this));
  }
  
  public void a(List<akrl> paramList)
  {
    this.jdField_a_of_type_Aiks.a(paramList);
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
      this.jdField_a_of_type_Bcqf.dismiss();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onAttach");
    }
  }
  
  public void onBackPressed()
  {
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().findViewById(16908290);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      int i = ImmersiveUtils.getStatusBarHeight(getActivity());
      if (paramBundle != null) {
        paramBundle.setMargins(0, i, 0, 0);
      }
      this.jdField_a_of_type_AndroidViewView.setSystemUiVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)bjal.a());
    if (this.jdField_a_of_type_Aejb == null)
    {
      paramBundle = (BinderWarpper)this.jdField_a_of_type_AndroidAppActivity.getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (paramBundle == null) {
        break label336;
      }
      this.jdField_a_of_type_Aejb = aejc.a(paramBundle.a);
      if (QLog.isColorLevel()) {
        QLog.d("SessionClearFragment", 2, "IAIOImageProvider is " + this.jdField_a_of_type_Aejb);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)bjal.a());
    this.jdField_a_of_type_Akrt = ((akrt)this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.getManager(4));
    this.jdField_a_of_type_Akrt.a(new aikh(this));
    this.jdField_a_of_type_Akrt.a(this.jdField_a_of_type_Aejb);
    this.jdField_a_of_type_Alxf = new alxf(this.jdField_a_of_type_AndroidAppActivity, 1);
    this.jdField_a_of_type_Alxf.a();
    this.jdField_a_of_type_Alxf.a(new aiki(this));
    this.jdField_b_of_type_Alxf = new alxf(this.jdField_a_of_type_AndroidAppActivity, 4);
    this.jdField_b_of_type_Alxf.a();
    this.jdField_b_of_type_Alxf.a(new aikj(this));
    this.jdField_c_of_type_Alxf = new alxf(this.jdField_a_of_type_AndroidAppActivity, 101);
    this.jdField_c_of_type_Alxf.a();
    this.jdField_c_of_type_Alxf.a(new aikk(this));
    this.jdField_a_of_type_Akrt.b();
    this.jdField_a_of_type_AndroidGraphicsBitmap = bbef.a();
    return;
    label336:
    throw new IllegalArgumentException("can't find Binder in Intent..");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131562421, paramViewGroup, false);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Akrt.onDestroy();
    this.jdField_a_of_type_Alxf.b();
    this.jdField_b_of_type_Alxf.b();
    this.jdField_c_of_type_Alxf.b();
    if (this.jdField_a_of_type_Bcqf != null) {
      this.jdField_a_of_type_Bcqf.dismiss();
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment
 * JD-Core Version:    0.7.0.1
 */