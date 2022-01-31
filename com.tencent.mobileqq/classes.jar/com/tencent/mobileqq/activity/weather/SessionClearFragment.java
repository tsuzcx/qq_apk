package com.tencent.mobileqq.activity.weather;

import abtv;
import aejd;
import aeje;
import aikj;
import aikk;
import aikl;
import aikm;
import aikn;
import aiko;
import aikr;
import aiks;
import aiku;
import ajyc;
import akrm;
import akru;
import alxg;
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
import anou;
import bbdj;
import bbdr;
import bcpq;
import bcpw;
import bizu;
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
  implements abtv
{
  private int jdField_a_of_type_Int = 0;
  private aejd jdField_a_of_type_Aejd;
  private aiku jdField_a_of_type_Aiku;
  private akru jdField_a_of_type_Akru;
  private alxg jdField_a_of_type_Alxg;
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
  private bcpq jdField_a_of_type_Bcpq;
  private PeakAppInterface jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface;
  List<akrm> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private alxg jdField_b_of_type_Alxg;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private int jdField_c_of_type_Int;
  private alxg jdField_c_of_type_Alxg;
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    anou localanou = new anou(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localanou, localanou);
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
    return localanou;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajyc.a(2131713851));
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajyc.a(2131713839));
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
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131375917));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131375788));
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376341));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131364996));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363376));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getActivity());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131365639));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Aiku = new aiku(this, new ArrayList());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aiku);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aikn(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new aiko(this));
    paramView.findViewById(2131364269).setOnClickListener(new aikr(this));
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (bbdj.b(paramString))
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
    if (i < this.jdField_a_of_type_Aiku.getItemCount())
    {
      if (this.jdField_a_of_type_Aiku.a(i).a) {
        localArrayList1.add(this.jdField_a_of_type_Aiku.a(i));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList2.add(this.jdField_a_of_type_Aiku.a(i));
      }
    }
    if (localArrayList1.size() > 0)
    {
      this.jdField_a_of_type_Akru.a(localArrayList1);
      if ((localArrayList2 != null) && (localArrayList2.size() != 0)) {
        break label149;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    for (;;)
    {
      bcpw.a(this.jdField_a_of_type_AndroidAppActivity, 2, 2131691514, 0).b(getResources().getDimensionPixelSize(2131298865));
      return;
      label149:
      this.jdField_a_of_type_Aiku.a(localArrayList2);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      a(0);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bcpq == null) {
      this.jdField_a_of_type_Bcpq = new bcpq(this.jdField_a_of_type_AndroidAppActivity, getResources().getDimensionPixelSize(2131298865));
    }
    this.jdField_a_of_type_Bcpq.setCancelable(false);
    this.jdField_a_of_type_Bcpq.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bcpq.a(ajyc.a(2131713846));
    this.jdField_a_of_type_Bcpq.show();
    this.jdField_a_of_type_Bcpq.a(new aiks(this));
  }
  
  public void a(List<akrm> paramList)
  {
    this.jdField_a_of_type_Aiku.a(paramList);
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
      this.jdField_a_of_type_Bcpq.dismiss();
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
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)bizu.a());
    if (this.jdField_a_of_type_Aejd == null)
    {
      paramBundle = (BinderWarpper)this.jdField_a_of_type_AndroidAppActivity.getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (paramBundle == null) {
        break label336;
      }
      this.jdField_a_of_type_Aejd = aeje.a(paramBundle.a);
      if (QLog.isColorLevel()) {
        QLog.d("SessionClearFragment", 2, "IAIOImageProvider is " + this.jdField_a_of_type_Aejd);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)bizu.a());
    this.jdField_a_of_type_Akru = ((akru)this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.getManager(4));
    this.jdField_a_of_type_Akru.a(new aikj(this));
    this.jdField_a_of_type_Akru.a(this.jdField_a_of_type_Aejd);
    this.jdField_a_of_type_Alxg = new alxg(this.jdField_a_of_type_AndroidAppActivity, 1);
    this.jdField_a_of_type_Alxg.a();
    this.jdField_a_of_type_Alxg.a(new aikk(this));
    this.jdField_b_of_type_Alxg = new alxg(this.jdField_a_of_type_AndroidAppActivity, 4);
    this.jdField_b_of_type_Alxg.a();
    this.jdField_b_of_type_Alxg.a(new aikl(this));
    this.jdField_c_of_type_Alxg = new alxg(this.jdField_a_of_type_AndroidAppActivity, 101);
    this.jdField_c_of_type_Alxg.a();
    this.jdField_c_of_type_Alxg.a(new aikm(this));
    this.jdField_a_of_type_Akru.b();
    this.jdField_a_of_type_AndroidGraphicsBitmap = bbdr.a();
    return;
    label336:
    throw new IllegalArgumentException("can't find Binder in Intent..");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131562422, paramViewGroup, false);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Akru.onDestroy();
    this.jdField_a_of_type_Alxg.b();
    this.jdField_b_of_type_Alxg.b();
    this.jdField_c_of_type_Alxg.b();
    if (this.jdField_a_of_type_Bcpq != null) {
      this.jdField_a_of_type_Bcpq.dismiss();
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment
 * JD-Core Version:    0.7.0.1
 */