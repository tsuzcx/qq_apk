package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import osm;
import osn;
import oso;
import osp;

public class QRLoginActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  static final short[] jdField_a_of_type_ArrayOfShort = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 63, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  public int a;
  public long a;
  public Handler a;
  public Button a;
  protected ImageView a;
  public LinearLayout a;
  public ProgressBar a;
  public TextView a;
  public QQProgressDialog a;
  public String a;
  private WtloginManager jdField_a_of_type_MqqManagerWtloginManager;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new osm(this);
  protected boolean a;
  protected byte[] a;
  public int b;
  public Button b;
  public ImageView b;
  public TextView b;
  protected String b;
  public int c;
  public TextView c;
  public String c;
  public int d;
  public String d;
  public int e;
  protected String e;
  public String f;
  
  public QRLoginActivity()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 2;
    this.jdField_d_of_type_Int = 3;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new osp(this);
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
    if (super.isFinishing()) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = super.getIntent().getStringExtra("QR_CODE_STRING");
    int i = this.jdField_b_of_type_JavaLangString.indexOf("?k=") + 3;
    Object localObject = this.jdField_b_of_type_JavaLangString.substring(i, i + 32);
    this.jdField_a_of_type_ArrayOfByte = a(((String)localObject).getBytes(), ((String)localObject).length());
    this.jdField_e_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.substring(this.jdField_b_of_type_JavaLangString.indexOf("&f=") + 3);
    localObject = this.jdField_a_of_type_MqqManagerWtloginManager;
    String str = this.jdField_a_of_type_JavaLangString;
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    WtloginObserver localWtloginObserver = this.jdField_a_of_type_MqqObserverWtloginObserver;
    ((WtloginManager)localObject).VerifyCode(str, 16L, true, arrayOfByte, new int[] { 3, 5, 32 }, 1, localWtloginObserver);
  }
  
  public void a(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    Object localObject;
    if (!HttpUtil.a(this))
    {
      localObject = DialogUtil.a(this, 230);
      ((QQCustomDialog)localObject).setMessage(2131429908);
      ((QQCustomDialog)localObject).setPositiveButton(2131432999, new oso(this));
      ((QQCustomDialog)localObject).show();
    }
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      localObject = getString(2131429946);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131429911);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  protected void a(boolean paramBoolean)
  {
    ((ActivateFriendsManager)this.app.getManager(84)).b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131429995);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnCancelListener(new osn(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    Object localObject1 = QRUtils.a(this.app.a());
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
  
  public void b()
  {
    if (!isFinishing())
    {
      localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
      localIntent.setFlags(67108864);
      super.startActivity(localIntent);
    }
    Toast.makeText(getApplicationContext(), 2131429947, 0).show();
    if (this.jdField_c_of_type_JavaLangString.equals("QQ"))
    {
      localIntent = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
      localIntent.putExtra("loginInfo", this.jdField_d_of_type_JavaLangString);
      localIntent.putExtra("status", "login");
      localIntent.putExtra("bannerTips", this.f);
      localIntent.putExtra("subappid", this.jdField_a_of_type_Long);
      localIntent.putExtra("appType", this.jdField_e_of_type_Int);
      super.sendBroadcast(localIntent);
    }
    while ((TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || (!"1600000104".equals(this.jdField_e_of_type_JavaLangString.trim()))) {
      return;
    }
    Intent localIntent = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
    localIntent.putExtra("loginInfo", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("loginAppId", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("status", "login");
    super.sendBroadcast(localIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130969695);
    super.setTitle(2131429910);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131367499));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131367504));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131367505));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131367501));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131367502));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131367503));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367500));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367497));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131367506));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.app.getManager(1));
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginActivity", 2, "wtloginManager:" + this.jdField_a_of_type_MqqManagerWtloginManager + " isLogin:" + this.app.isLogin());
    }
    if (this.app.isLogin())
    {
      a();
      return true;
    }
    a(null);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131367504) && (this.jdField_a_of_type_Boolean))
    {
      paramView = new Intent(this, ScannerActivity.class);
      paramView.setFlags(67108864);
      startActivity(paramView);
      return;
    }
    if (paramView.getId() == 2131367504) {}
    for (int i = this.jdField_a_of_type_Int; i == 0; i = this.jdField_c_of_type_Int)
    {
      finish();
      return;
    }
    if (i == 2) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginActivity
 * JD-Core Version:    0.7.0.1
 */