package com.tencent.mobileqq.activity.weather;

import aeox;
import ahtp;
import ahtq;
import amdq;
import amdr;
import amds;
import amdt;
import amdu;
import amdv;
import amdy;
import amdz;
import ameb;
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
import anvx;
import aoqb;
import aoqj;
import aqcx;
import asbg;
import bheg;
import bisl;
import bofz;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SessionClearFragment
  extends PublicBaseFragment
  implements aeox
{
  private int jdField_a_of_type_Int = 0;
  private ahtp jdField_a_of_type_Ahtp;
  private ameb jdField_a_of_type_Ameb;
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
  private aoqj jdField_a_of_type_Aoqj;
  private aqcx jdField_a_of_type_Aqcx;
  private bisl jdField_a_of_type_Bisl;
  private PeakAppInterface jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface;
  List<aoqb> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private aqcx jdField_b_of_type_Aqcx;
  private int jdField_c_of_type_Int;
  private aqcx jdField_c_of_type_Aqcx;
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    asbg localasbg = new asbg(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localasbg, localasbg);
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
    return localasbg;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(anvx.a(2131713304));
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setText(anvx.a(2131713292));
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
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131377438));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131377286));
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377907));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131365489));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363733));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getActivity());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366142));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Ameb = new ameb(this, new ArrayList());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Ameb);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new amdu(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new amdv(this));
    paramView.findViewById(2131364708).setOnClickListener(new amdy(this));
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      paramString = ShortVideoUtils.getThumbUrl(paramString);
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
    if (i < this.jdField_a_of_type_Ameb.getItemCount())
    {
      if (this.jdField_a_of_type_Ameb.a(i).a) {
        localArrayList1.add(this.jdField_a_of_type_Ameb.a(i));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList2.add(this.jdField_a_of_type_Ameb.a(i));
      }
    }
    if (localArrayList1.size() > 0)
    {
      this.jdField_a_of_type_Aoqj.a(localArrayList1);
      if ((localArrayList2 != null) && (localArrayList2.size() != 0)) {
        break label149;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    for (;;)
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2, 2131691456, 0).b(getResources().getDimensionPixelSize(2131299080));
      return;
      label149:
      this.jdField_a_of_type_Ameb.a(localArrayList2);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      a(0);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bisl == null) {
      this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_AndroidAppActivity, getResources().getDimensionPixelSize(2131299080));
    }
    this.jdField_a_of_type_Bisl.setCancelable(false);
    this.jdField_a_of_type_Bisl.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bisl.a(anvx.a(2131713299));
    this.jdField_a_of_type_Bisl.show();
    this.jdField_a_of_type_Bisl.a(new amdz(this));
  }
  
  public void a(List<aoqb> paramList)
  {
    this.jdField_a_of_type_Ameb.a(paramList);
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      this.jdField_a_of_type_Bisl.dismiss();
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
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)bofz.a());
    if (this.jdField_a_of_type_Ahtp == null)
    {
      paramBundle = (BinderWarpper)this.jdField_a_of_type_AndroidAppActivity.getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (paramBundle == null) {
        break label336;
      }
      this.jdField_a_of_type_Ahtp = ahtq.a(paramBundle.a);
      if (QLog.isColorLevel()) {
        QLog.d("SessionClearFragment", 2, "IAIOImageProvider is " + this.jdField_a_of_type_Ahtp);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)bofz.a());
    this.jdField_a_of_type_Aoqj = ((aoqj)this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.getManager(4));
    this.jdField_a_of_type_Aoqj.a(new amdq(this));
    this.jdField_a_of_type_Aoqj.a(this.jdField_a_of_type_Ahtp);
    this.jdField_a_of_type_Aqcx = new aqcx(this.jdField_a_of_type_AndroidAppActivity, 1);
    this.jdField_a_of_type_Aqcx.a();
    this.jdField_a_of_type_Aqcx.a(new amdr(this));
    this.jdField_b_of_type_Aqcx = new aqcx(this.jdField_a_of_type_AndroidAppActivity, 4);
    this.jdField_b_of_type_Aqcx.a();
    this.jdField_b_of_type_Aqcx.a(new amds(this));
    this.jdField_c_of_type_Aqcx = new aqcx(this.jdField_a_of_type_AndroidAppActivity, 101);
    this.jdField_c_of_type_Aqcx.a();
    this.jdField_c_of_type_Aqcx.a(new amdt(this));
    this.jdField_a_of_type_Aoqj.b();
    this.jdField_a_of_type_AndroidGraphicsBitmap = bheg.a();
    return;
    label336:
    throw new IllegalArgumentException("can't find Binder in Intent..");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131562865, paramViewGroup, false);
    a(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Aoqj.onDestroy();
    this.jdField_a_of_type_Aqcx.b();
    this.jdField_b_of_type_Aqcx.b();
    this.jdField_c_of_type_Aqcx.b();
    if (this.jdField_a_of_type_Bisl != null) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment
 * JD-Core Version:    0.7.0.1
 */