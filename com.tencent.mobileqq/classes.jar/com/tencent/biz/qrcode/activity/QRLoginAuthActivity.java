package com.tencent.biz.qrcode.activity;

import amga;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import azqs;
import bdgm;
import bdjz;
import bety;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import ndd;
import xzp;
import xzq;
import xzr;
import xzs;
import yak;
import ybi;
import ybk;

public class QRLoginAuthActivity
  extends QRLoginBaseActivity
  implements View.OnClickListener
{
  static final short[] jdField_a_of_type_ArrayOfShort = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 63, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  public int a;
  public long a;
  public Handler a;
  protected Button a;
  public ImageView a;
  public LinearLayout a;
  public ProgressBar a;
  protected RelativeLayout a;
  public TextView a;
  public bety a;
  public String a;
  private WtloginManager jdField_a_of_type_MqqManagerWtloginManager;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new xzp(this);
  public boolean a;
  protected byte[] a;
  public int b;
  public Button b;
  public TextView b;
  protected String b;
  protected boolean b;
  public String c;
  private boolean c;
  public String d;
  protected String e;
  public String f;
  
  public QRLoginAuthActivity()
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new xzs(this);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[24];
    int n = 0;
    int m = 0;
    int i = 0;
    int j = 0;
    int k = paramInt;
    paramInt = n;
    n = k - 1;
    int i1 = i;
    if (k > 0)
    {
      i = j + 1;
      j = paramArrayOfByte[j];
      i1 = j;
      if (j != 0)
      {
        if (j != 95) {
          break label107;
        }
        i1 = j;
      }
    }
    if (i1 == 95)
    {
      i = paramInt;
      switch (m % 4)
      {
      }
    }
    for (;;)
    {
      return arrayOfByte;
      label107:
      k = j;
      if (j == 32) {
        k = 42;
      }
      j = jdField_a_of_type_ArrayOfShort[k];
      if (j < 0)
      {
        k = n;
        n = i;
        i = j;
        j = n;
        break;
      }
      switch (m % 4)
      {
      }
      for (;;)
      {
        i1 = m + 1;
        k = n;
        m = j;
        j = i;
        i = m;
        m = i1;
        break;
        arrayOfByte[paramInt] = ((byte)(j << 2));
        continue;
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | j >> 4));
        arrayOfByte[k] = ((byte)((j & 0xF) << 4));
        paramInt = k;
        continue;
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | j >> 2));
        arrayOfByte[k] = ((byte)((j & 0x3) << 6));
        paramInt = k;
        continue;
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | j));
        paramInt = k;
      }
      return null;
      i = paramInt + 1;
      arrayOfByte[i] = 0;
    }
  }
  
  protected void a()
  {
    super.setContentView(2131560235);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131369854));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131373903));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131364690));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131378048));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370019));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372204));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365189));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131373904));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void a(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    Object localObject;
    if (!ndd.a(this))
    {
      localObject = bdgm.a(this, 230);
      ((bdjz)localObject).setMessage(2131719403);
      ((bdjz)localObject).setPositiveButton(2131694953, new xzr(this));
      ((bdjz)localObject).show();
    }
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      localObject = getString(2131719401);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839476));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131719400);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  protected void a(boolean paramBoolean)
  {
    ((amga)this.app.getManager(85)).b();
    this.jdField_a_of_type_Bety = new bety(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bety.c(2131717638);
    this.jdField_a_of_type_Bety.setOnCancelListener(new xzq(this));
    this.jdField_a_of_type_Bety.show();
    Object localObject1 = ybk.a(this.app.a());
    Object localObject2 = ByteBuffer.allocate(localObject1.length + 4);
    ((ByteBuffer)localObject2).putShort((short)2);
    ((ByteBuffer)localObject2).putShort((short)localObject1.length);
    ((ByteBuffer)localObject2).put((byte[])localObject1);
    localObject2 = ((ByteBuffer)localObject2).array();
    Object localObject3 = this.app.b(this.jdField_a_of_type_JavaLangString);
    localObject1 = new ArrayList();
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((String)localObject3).equals(this.jdField_a_of_type_JavaLangString)))
    {
      localObject3 = ((String)localObject3).getBytes();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(localObject3.length + 4);
      localByteBuffer.putShort((short)1);
      localByteBuffer.putShort((short)localObject3.length);
      localByteBuffer.put((byte[])localObject3);
      localObject3 = localByteBuffer.array();
      localByteBuffer = ByteBuffer.allocate(localObject3.length + 4);
      localByteBuffer.putShort((short)4);
      localByteBuffer.putShort((short)localObject3.length);
      localByteBuffer.put((byte[])localObject3);
      localObject3 = localByteBuffer.array();
      ((ArrayList)localObject1).add(HexUtil.bytes2HexStr((byte[])localObject2));
      ((ArrayList)localObject1).add(HexUtil.bytes2HexStr((byte[])localObject3));
      localObject2 = ByteBuffer.allocate(8);
      ((ByteBuffer)localObject2).putShort((short)21);
      ((ByteBuffer)localObject2).putShort((short)4);
      if (!paramBoolean) {
        break label354;
      }
    }
    label354:
    for (int i = 1;; i = 0)
    {
      ((ByteBuffer)localObject2).putInt(i);
      ((ArrayList)localObject1).add(HexUtil.bytes2HexStr(((ByteBuffer)localObject2).array()));
      this.jdField_a_of_type_MqqManagerWtloginManager.CloseCode(this.jdField_a_of_type_JavaLangString, 16L, this.jdField_a_of_type_ArrayOfByte, 1, (ArrayList)localObject1, this.jdField_a_of_type_MqqObserverWtloginObserver);
      return;
      ((ArrayList)localObject1).add(HexUtil.bytes2HexStr((byte[])localObject2));
      break;
    }
  }
  
  protected void b()
  {
    if (super.isFinishing()) {
      return;
    }
    Object localObject = super.getIntent();
    this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("QR_CODE_STRING");
    this.c = ((Intent)localObject).getBooleanExtra("KEY_QR_CODE_EXPIRED", false);
    int i = this.jdField_b_of_type_JavaLangString.indexOf("?k=") + 3;
    localObject = this.jdField_b_of_type_JavaLangString.substring(i, i + 32);
    this.jdField_a_of_type_ArrayOfByte = a(((String)localObject).getBytes(), ((String)localObject).length());
    this.e = this.jdField_b_of_type_JavaLangString.substring(this.jdField_b_of_type_JavaLangString.indexOf("&f=") + 3);
    localObject = this.jdField_a_of_type_MqqManagerWtloginManager;
    String str = this.jdField_a_of_type_JavaLangString;
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    WtloginObserver localWtloginObserver = this.jdField_a_of_type_MqqObserverWtloginObserver;
    ((WtloginManager)localObject).VerifyCode(str, 16L, true, arrayOfByte, new int[] { 3, 5, 32, 53 }, 1, localWtloginObserver);
  }
  
  public void c()
  {
    if (!isFinishing())
    {
      localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
      localIntent.setFlags(67108864);
      super.startActivity(localIntent);
    }
    Toast.makeText(getApplicationContext(), 2131719402, 0).show();
    if ((!TextUtils.isEmpty(this.e)) && ("1600000104".equals(this.e.trim())))
    {
      localIntent = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
      localIntent.putExtra("loginInfo", this.d);
      localIntent.putExtra("loginAppId", this.e);
      localIntent.putExtra("status", "login");
      super.sendBroadcast(localIntent);
      return;
    }
    Intent localIntent = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
    localIntent.putExtra("loginInfo", this.d);
    localIntent.putExtra("status", "login");
    localIntent.putExtra("bannerTips", this.f);
    localIntent.putExtra("subappid", this.jdField_a_of_type_Long);
    localIntent.putExtra("appType", this.jdField_b_of_type_Int);
    super.sendBroadcast(localIntent);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    this.jdField_a_of_type_MqqManagerWtloginManager.cancelCode(getCurrentAccountUin(), 16L, this.jdField_a_of_type_ArrayOfByte);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.app.getManager(1));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginAuthActivity", 2, "wtloginManager:" + this.jdField_a_of_type_MqqManagerWtloginManager + " isLogin:" + this.app.isLogin());
    }
    if (this.app.isLogin())
    {
      b();
      return true;
    }
    a(null);
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      this.jdField_a_of_type_Bety.dismiss();
    }
    super.doOnDestroy();
    yak.a(this);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131364690) {
      if (this.jdField_b_of_type_Boolean)
      {
        paramView = new Intent(this, ScannerActivity.class);
        paramView.setFlags(67108864);
        startActivity(paramView);
        if (this.c) {
          finish();
        }
      }
    }
    do
    {
      return;
      a(false);
      azqs.b(null, "dc00898", "", "", "0X800A46E", "0X800A46E", ybi.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
      return;
      if (i == 2131378048)
      {
        a(true);
        azqs.b(null, "dc00898", "", "", "0X800A46F", "0X800A46F", ybi.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
        return;
      }
    } while (i != 2131369342);
    finish();
    this.jdField_a_of_type_MqqManagerWtloginManager.cancelCode(getCurrentAccountUin(), 16L, this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginAuthActivity
 * JD-Core Version:    0.7.0.1
 */