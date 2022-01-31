package com.tencent.mobileqq.activity.weather;

import abjv;
import adye;
import adyf;
import ahxq;
import ahxr;
import ahxs;
import ahxt;
import ahxu;
import ahxv;
import ahxy;
import ahxz;
import ahyb;
import ajjy;
import akda;
import akdi;
import alis;
import amym;
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
import bace;
import bacm;
import bbms;
import bbmy;
import bhfc;
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
  implements abjv
{
  private int jdField_a_of_type_Int = 0;
  private adye jdField_a_of_type_Adye;
  private ahyb jdField_a_of_type_Ahyb;
  private akdi jdField_a_of_type_Akdi;
  private alis jdField_a_of_type_Alis;
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
  private bbms jdField_a_of_type_Bbms;
  private PeakAppInterface jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface;
  List<akda> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private alis jdField_b_of_type_Alis;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private int jdField_c_of_type_Int;
  private alis jdField_c_of_type_Alis;
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    amym localamym = new amym(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localamym, localamym);
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
    return localamym;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajjy.a(2131648063));
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajjy.a(2131648051));
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
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131310153));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131310024));
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131310549));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131299428));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131297830));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getActivity());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131300043));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Ahyb = new ahyb(this, new ArrayList());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Ahyb);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ahxu(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new ahxv(this));
    paramView.findViewById(2131298711).setOnClickListener(new ahxy(this));
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (bace.b(paramString))
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
    if (i < this.jdField_a_of_type_Ahyb.getItemCount())
    {
      if (this.jdField_a_of_type_Ahyb.a(i).a) {
        localArrayList1.add(this.jdField_a_of_type_Ahyb.a(i));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList2.add(this.jdField_a_of_type_Ahyb.a(i));
      }
    }
    if (localArrayList1.size() > 0)
    {
      this.jdField_a_of_type_Akdi.a(localArrayList1);
      if ((localArrayList2 != null) && (localArrayList2.size() != 0)) {
        break label149;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    for (;;)
    {
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 2, 2131625938, 0).b(getResources().getDimensionPixelSize(2131167766));
      return;
      label149:
      this.jdField_a_of_type_Ahyb.a(localArrayList2);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      a(0);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bbms == null) {
      this.jdField_a_of_type_Bbms = new bbms(this.jdField_a_of_type_AndroidAppActivity, getResources().getDimensionPixelSize(2131167766));
    }
    this.jdField_a_of_type_Bbms.setCancelable(false);
    this.jdField_a_of_type_Bbms.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bbms.a(ajjy.a(2131648058));
    this.jdField_a_of_type_Bbms.show();
    this.jdField_a_of_type_Bbms.a(new ahxz(this));
  }
  
  public void a(List<akda> paramList)
  {
    this.jdField_a_of_type_Ahyb.a(paramList);
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
      this.jdField_a_of_type_Bbms.dismiss();
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
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)bhfc.a());
    if (this.jdField_a_of_type_Adye == null)
    {
      paramBundle = (BinderWarpper)this.jdField_a_of_type_AndroidAppActivity.getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (paramBundle == null) {
        break label336;
      }
      this.jdField_a_of_type_Adye = adyf.a(paramBundle.a);
      if (QLog.isColorLevel()) {
        QLog.d("SessionClearFragment", 2, "IAIOImageProvider is " + this.jdField_a_of_type_Adye);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)bhfc.a());
    this.jdField_a_of_type_Akdi = ((akdi)this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.getManager(4));
    this.jdField_a_of_type_Akdi.a(new ahxq(this));
    this.jdField_a_of_type_Akdi.a(this.jdField_a_of_type_Adye);
    this.jdField_a_of_type_Alis = new alis(this.jdField_a_of_type_AndroidAppActivity, 1);
    this.jdField_a_of_type_Alis.a();
    this.jdField_a_of_type_Alis.a(new ahxr(this));
    this.jdField_b_of_type_Alis = new alis(this.jdField_a_of_type_AndroidAppActivity, 4);
    this.jdField_b_of_type_Alis.a();
    this.jdField_b_of_type_Alis.a(new ahxs(this));
    this.jdField_c_of_type_Alis = new alis(this.jdField_a_of_type_AndroidAppActivity, 101);
    this.jdField_c_of_type_Alis.a();
    this.jdField_c_of_type_Alis.a(new ahxt(this));
    this.jdField_a_of_type_Akdi.b();
    this.jdField_a_of_type_AndroidGraphicsBitmap = bacm.a();
    return;
    label336:
    throw new IllegalArgumentException("can't find Binder in Intent..");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131496822, paramViewGroup, false);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Akdi.onDestroy();
    this.jdField_a_of_type_Alis.b();
    this.jdField_b_of_type_Alis.b();
    this.jdField_c_of_type_Alis.b();
    if (this.jdField_a_of_type_Bbms != null) {
      this.jdField_a_of_type_Bbms.dismiss();
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment
 * JD-Core Version:    0.7.0.1
 */