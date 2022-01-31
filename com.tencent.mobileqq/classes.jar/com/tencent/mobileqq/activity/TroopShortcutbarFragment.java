package com.tencent.mobileqq.activity;

import acna;
import acnb;
import acnc;
import ajyc;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import axqw;
import aywk;
import bafa;
import bafd;
import bafe;
import baff;
import bafg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopShortcutbarFragment
  extends IphoneTitleBarFragment
  implements CompoundButton.OnCheckedChangeListener
{
  int jdField_a_of_type_Int;
  public long a;
  public FragmentActivity a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bafg jdField_a_of_type_Bafg;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Switch jdField_a_of_type_ComTencentWidgetSwitch;
  public ArrayList<Pair<URLDrawable, URLImageView>> a;
  boolean jdField_a_of_type_Boolean = false;
  boolean b;
  
  public TroopShortcutbarFragment()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {}
    Object localObject1;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      localObject2 = (baff)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355);
      localObject1 = (bafd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(171);
    } while (localObject2 == null);
    Object localObject2 = ((baff)localObject2).b(Long.valueOf(this.jdField_a_of_type_Long));
    if (localObject2 != null)
    {
      if ((paramBoolean) && (((bafe)localObject2).a() < System.currentTimeMillis()) && (localObject1 != null)) {
        ((bafd)localObject1).b(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
      }
      if (((this.b) && (((bafe)localObject2).b() == 0)) || ((!this.b) && (((bafe)localObject2).a() == 0)))
      {
        this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131696505);
        localObject1 = ((bafe)localObject2).a();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        localObject1 = ((ArrayList)localObject1).iterator();
        for (;;)
        {
          label163:
          if (!((Iterator)localObject1).hasNext()) {
            break label469;
          }
          localObject2 = (bafa)((Iterator)localObject1).next();
          try
          {
            if ((this.b) || (((bafa)localObject2).a() != 1))
            {
              localObject3 = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561179, null);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
              localObject4 = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561177, null);
              ((View)localObject4).setBackgroundResource(2130849552);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
              ((View)localObject4).getLayoutParams().height = 2;
              ((TextView)((View)localObject3).findViewById(2131377350)).setText(((bafa)localObject2).a());
              localObject4 = (Switch)((View)localObject3).findViewById(2131375949);
              if (!this.b) {
                break label517;
              }
              acnb localacnb = new acnb();
              localacnb.jdField_a_of_type_Int = 1;
              localacnb.jdField_a_of_type_Long = ((bafa)localObject2).a();
              ((Switch)localObject4).setTag(localacnb);
              if (((bafa)localObject2).a() != 0) {
                break label512;
              }
              paramBoolean = true;
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              Object localObject4;
              if (QLog.isColorLevel()) {
                QLog.e("TroopShortcutbarFragment", 2, "TroopShortcutbarFragment.updateView got OOM, e:" + localOutOfMemoryError.getMessage());
              }
              System.gc();
              return;
              paramBoolean = false;
              continue;
              ((Switch)localObject4).setVisibility(8);
            }
          }
          catch (InflateException localInflateException)
          {
            if (!QLog.isColorLevel()) {
              break label564;
            }
            QLog.e("TroopShortcutbarFragment", 2, "TroopShortcutbarFragment.updateView got InflateException, e:" + localInflateException.getMessage());
            System.gc();
            return;
          }
        }
        ((Switch)localObject4).setChecked(paramBoolean);
        ((Switch)localObject4).setOnCheckedChangeListener(this);
        Object localObject3 = (URLImageView)((View)localObject3).findViewById(2131376081);
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = aywk.a;
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = aywk.a;
        ((URLDrawable.URLDrawableOptions)localObject4).mUseAutoScaleParams = false;
        if (((bafa)localObject2).b() != null)
        {
          localObject2 = URLDrawable.getDrawable(((bafa)localObject2).b(), (URLDrawable.URLDrawableOptions)localObject4);
          if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            ((URLImageView)localObject3).setColorFilter(1996488704);
          }
          if (((URLDrawable)localObject2).getStatus() == 1)
          {
            localObject2 = ((URLDrawable)localObject2).getCurrDrawable();
            if ((localObject2 instanceof RegionDrawable))
            {
              ((URLImageView)localObject3).setImageBitmap(((RegionDrawable)localObject2).getBitmap());
              ((URLImageView)localObject3).setVisibility(0);
            }
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          break label163;
          label469:
          break;
          label512:
          label517:
          label564:
          this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(localObject2, localObject3));
          ((URLDrawable)localObject2).setURLDrawableListener(new acnc(this));
          if (!((URLDrawable)localObject2).isDownloadStarted())
          {
            ((URLDrawable)localObject2).startDownload();
            continue;
            ((URLImageView)localObject3).setImageDrawable(getResources().getDrawable(2130843105));
          }
        }
      }
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131696506);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      return;
    }
    if ((paramBoolean) && (localInflateException != null)) {
      localInflateException.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131696506);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app == null) || (this.mContentView == null))
    {
      QLog.e("TroopShortcutbarFragment", 1, "doOnCreateView error mActivity:" + this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity + " mContentView:" + this.mContentView);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)this.mContentView.findViewById(2131375951));
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setTag(new acnb());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131376083));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131376082));
    paramViewGroup = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    paramLayoutInflater = paramViewGroup.getStringExtra("troopuin");
    this.jdField_a_of_type_Long = Long.parseLong(paramLayoutInflater);
    this.jdField_a_of_type_Int = ((int)paramViewGroup.getLongExtra("trooptype", 0L));
    this.b = paramViewGroup.getBooleanExtra("isManagerPage", false);
    paramViewGroup = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramViewGroup instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramViewGroup);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_Bafg = new acna(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bafg);
    }
    a(true);
    setTitle(ajyc.a(2131696507));
    paramViewGroup = this.leftView;
    paramBundle = getString(2131690572);
    if (paramViewGroup != null)
    {
      paramViewGroup.setText("");
      paramViewGroup.setContentDescription(paramBundle);
    }
    axqw.b(null, "dc00898", "", "", "0X800AAD8", "0X800AAD8", 0, 0, "", paramLayoutInflater, String.valueOf(this.jdField_a_of_type_Int), "");
  }
  
  public int getContentLayoutId()
  {
    return 2131559703;
  }
  
  public boolean onBackEvent()
  {
    Intent localIntent = new Intent();
    if (!this.jdField_a_of_type_ComTencentWidgetSwitch.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("disabled", bool);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      getActivity().finish();
      return true;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    bafd localbafd;
    Object localObject;
    label66:
    label196:
    label207:
    label249:
    do
    {
      bafe localbafe;
      do
      {
        return;
        paramCompoundButton = (acnb)paramCompoundButton.getTag();
        localbafd = (bafd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(171);
        localObject = (baff)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355);
        localbafe = ((baff)localObject).b(Long.valueOf(this.jdField_a_of_type_Long));
        if (!paramBoolean) {
          break;
        }
        i = 0;
        if ((paramCompoundButton == null) || (localbafd == null) || (localObject == null) || (localbafe == null)) {
          break label196;
        }
        if (paramCompoundButton.jdField_a_of_type_Int != 0) {
          break label249;
        }
      } while (((!this.b) || (localbafe.b() == i)) && ((this.b) || (localbafe.a() == i)));
      if (this.b) {
        localbafe.b(i);
      }
      for (;;)
      {
        localbafd.c(this.jdField_a_of_type_Long, i);
        if (!paramBoolean) {
          break label207;
        }
        axqw.b(null, "dc00898", "", "", "0X800AAD9", "0X800AAD9", 0, 0, "", String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Int), "");
        return;
        i = 1;
        break label66;
        break;
        localbafe.a(i);
      }
      axqw.b(null, "dc00898", "", "", "0X800AADA", "0X800AADA", 0, 0, "", String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Int), "");
      return;
      if ((localbafe.a(paramCompoundButton.jdField_a_of_type_Long)) && (!paramBoolean))
      {
        localbafd.c(this.jdField_a_of_type_Long, i);
        axqw.b(null, "dc00898", "", "", "0X800AADA", "0X800AADA", 0, 0, "", String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Int), "");
        axqw.b(null, "dc00898", "", "", "0X800AADC", "0X800AADC", 0, 0, String.valueOf(paramCompoundButton.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Int), "");
        return;
      }
      localObject = localbafe.a(paramCompoundButton.jdField_a_of_type_Long);
    } while ((localObject == null) || (((bafa)localObject).a() == i));
    ((bafa)localObject).a(i);
    long l1 = this.jdField_a_of_type_Long;
    long l2 = paramCompoundButton.jdField_a_of_type_Long;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localbafd.a(l1, l2, i);
      if (!paramBoolean) {
        break;
      }
      axqw.b(null, "dc00898", "", "", "0X800AADB", "0X800AADB", 0, 0, String.valueOf(((bafa)localObject).a()), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Int), "");
      return;
    }
    axqw.b(null, "dc00898", "", "", "0X800AADC", "0X800AADC", 0, 0, String.valueOf(((bafa)localObject).a()), String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Int), "");
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bafg);
    }
    this.jdField_a_of_type_Bafg = null;
    super.onDestroy();
  }
  
  public void onFinish()
  {
    Intent localIntent = new Intent();
    if (!this.jdField_a_of_type_ComTencentWidgetSwitch.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("disabled", bool);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, localIntent);
      super.onFinish();
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Boolean = false;
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopShortcutbarFragment
 * JD-Core Version:    0.7.0.1
 */