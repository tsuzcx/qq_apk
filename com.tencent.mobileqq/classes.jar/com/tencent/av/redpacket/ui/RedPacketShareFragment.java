package com.tencent.av.redpacket.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import jly;
import jma;
import jmc;
import jme;

@TargetApi(11)
public class RedPacketShareFragment
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener
{
  public Bitmap a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  public VideoAppInterface a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private String b;
  public boolean b;
  
  public RedPacketShareFragment()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  private Bitmap a(View paramView)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramView.layout(0, 0, i, j);
    paramView.draw(localCanvas);
    return localBitmap;
  }
  
  @Nullable
  private String a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    do
    {
      return null;
      try
      {
        String str = "temp_qav_redpacket_share_" + System.currentTimeMillis() + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ".png";
        str = QRUtils.a(getActivity(), str, this.jdField_a_of_type_AndroidGraphicsBitmap);
        return str;
      }
      catch (OutOfMemoryError localOutOfMemoryError) {}
    } while (!QLog.isColorLevel());
    QLog.i("RedPacketShareFragment", 2, localOutOfMemoryError.getMessage());
    return null;
  }
  
  private static String a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketShareFragment", 2, "hitEmojiCntToExceedPercent, hitEmojiCnt=" + paramInt);
    }
    if (paramInt <= 3) {}
    do
    {
      return "20%";
      if ((paramInt >= 4) && (paramInt <= 5)) {
        return "30%";
      }
      if ((paramInt >= 6) && (paramInt <= 7)) {
        return "40%";
      }
      if (paramInt == 8) {
        return "50%";
      }
      if ((paramInt >= 9) && (paramInt <= 10)) {
        return "60%";
      }
      if ((paramInt >= 11) && (paramInt <= 12)) {
        return "70%";
      }
      if ((paramInt >= 13) && (paramInt <= 14)) {
        return "80%";
      }
      if (paramInt == 15) {
        return "90%";
      }
    } while (paramInt != 16);
    return "99.99%";
  }
  
  private void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(BaseApplication.getContext(), 2131439091, 0).a();
      return;
    }
    int i;
    if ((paramInt == 2) || (paramInt == 3)) {
      if (!WXShareHelper.a().a()) {
        i = 2131435319;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        QRUtils.a(1, i);
        return;
        if (!WXShareHelper.a().b()) {
          i = 2131435320;
        }
      }
      else
      {
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
        {
          QRUtils.a(1, 2131439090);
          return;
        }
        a(true);
        if (paramInt == 0)
        {
          c();
          ThreadManager.postImmediately(new jly(this), null, true);
          return;
        }
        if (paramInt == 1)
        {
          c();
          ThreadManager.postImmediately(new jma(this), null, true);
          return;
        }
        if ((paramInt != 2) && (paramInt != 3)) {
          break;
        }
        c();
        ThreadManager.postImmediately(new jmc(this, paramInt), null, true);
        return;
      }
      i = -1;
    }
  }
  
  private void a(View paramView)
  {
    Object localObject1 = (Button)paramView.findViewById(2131363687);
    Object localObject2 = (Button)paramView.findViewById(2131363688);
    Button localButton1 = (Button)paramView.findViewById(2131364328);
    Button localButton2 = (Button)paramView.findViewById(2131364329);
    View localView = paramView.findViewById(2131366245);
    paramView = paramView.findViewById(2131362868);
    ((Button)localObject1).setOnClickListener(this);
    ((Button)localObject2).setOnClickListener(this);
    localButton1.setOnClickListener(this);
    localButton2.setOnClickListener(this);
    localView.setOnClickListener(this);
    paramView.setOnClickListener(this);
    a((Button)localObject1, 2130838336);
    a((Button)localObject2, 2130838337);
    a(localButton1, 2130838340);
    a(localButton2, 2130838334);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localObject2 = (AVRedPacketManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(6);
      if (localObject2 != null)
      {
        localObject1 = ((AVRedPacketManager)localObject2).a("qav_redpacket_share_save.png");
        localObject2 = ((AVRedPacketManager)localObject2).a("qav_redpacket_share_close.png");
        a(localView, (Bitmap)localObject1);
        a(paramView, (Bitmap)localObject2);
      }
    }
  }
  
  private void a(View paramView, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      Object localObject = getResources();
      BitmapDrawable localBitmapDrawable = new BitmapDrawable((Resources)localObject, paramBitmap);
      paramBitmap = new BitmapDrawable((Resources)localObject, paramBitmap);
      paramBitmap.setAlpha(128);
      localObject = new StateListDrawable();
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, paramBitmap);
      ((StateListDrawable)localObject).addState(new int[] { -16842919 }, localBitmapDrawable);
      ((StateListDrawable)localObject).setBounds(0, 0, localBitmapDrawable.getIntrinsicWidth(), localBitmapDrawable.getIntrinsicHeight());
      paramView.setBackgroundDrawable((Drawable)localObject);
    }
  }
  
  private void a(Button paramButton, int paramInt)
  {
    Object localObject1 = getResources();
    Object localObject2 = null;
    try
    {
      localObject1 = BitmapFactory.decodeResource((Resources)localObject1, paramInt);
      a(paramButton, (Bitmap)localObject1);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("RedPacketShareFragment", 2, "setButtonDrawable e = " + localOutOfMemoryError);
          localObject1 = localObject2;
        }
      }
    }
  }
  
  private void a(Button paramButton, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      Object localObject = getResources();
      BitmapDrawable localBitmapDrawable = new BitmapDrawable((Resources)localObject, paramBitmap);
      paramBitmap = new BitmapDrawable((Resources)localObject, paramBitmap);
      paramBitmap.setAlpha(128);
      localObject = new StateListDrawable();
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, paramBitmap);
      ((StateListDrawable)localObject).addState(new int[] { -16842919 }, localBitmapDrawable);
      ((StateListDrawable)localObject).setBounds(0, 0, localBitmapDrawable.getIntrinsicWidth(), localBitmapDrawable.getIntrinsicHeight());
      paramButton.setCompoundDrawables(null, (Drawable)localObject, null, null);
    }
  }
  
  @TargetApi(12)
  private void b(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Object localObject2 = (AVRedPacketManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(6);
      if (localObject2 != null)
      {
        Object localObject3 = ((AVRedPacketManager)localObject2).a();
        ((AVRedPacketManager)localObject2).a(null);
        Object localObject1 = (ViewGroup)getActivity().getLayoutInflater().inflate(2130969350, null);
        ((ViewGroup)localObject1).findViewById(2131362840).setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject3));
        localObject3 = ((AVRedPacketManager)localObject2).a("qav_redpacket_share_preview_background.png");
        if (localObject3 != null) {
          ((ViewGroup)localObject1).findViewById(2131362745).setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject3));
        }
        localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        Object localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, (String)localObject3, null, true, true);
        if (localObject4 != null) {
          ((ViewGroup)localObject1).findViewById(2131363063).setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject4));
        }
        if (getArguments().getBoolean("isGoodScore"))
        {
          localObject4 = ((AVRedPacketManager)localObject2).a("qav_redpacket_result_bqd.png");
          if (localObject4 != null) {
            ((ViewGroup)localObject1).findViewById(2131366246).setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject4));
          }
        }
        localObject4 = (TextView)((ViewGroup)localObject1).findViewById(2131366247);
        this.jdField_a_of_type_JavaLangString = Integer.toString(getArguments().getInt("score"));
        ((TextView)localObject4).setText(this.jdField_a_of_type_JavaLangString);
        localObject4 = (TextView)((ViewGroup)localObject1).findViewById(2131363901);
        Object localObject5 = getString(2131429672);
        this.jdField_b_of_type_JavaLangString = a(getArguments().getInt("count"));
        String str = this.jdField_b_of_type_JavaLangString;
        Object localObject6 = String.format((String)localObject5, new Object[] { str });
        localObject5 = new ForegroundColorSpan(-410357);
        localObject6 = new SpannableString((CharSequence)localObject6);
        ((SpannableString)localObject6).setSpan(localObject5, 3, str.length() + 3, 17);
        ((TextView)localObject4).setText((CharSequence)localObject6);
        ((TextView)((ViewGroup)localObject1).findViewById(2131366249)).setText(String.format(getString(2131429673), new Object[] { this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(0, (String)localObject3, null) }));
        localObject2 = ((AVRedPacketManager)localObject2).a("qav_redpacket_share_preview_qrcode.png", false);
        if (localObject2 != null) {
          ((ViewGroup)localObject1).findViewById(2131366250).setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject2));
        }
        ((ViewGroup)localObject1).measure(View.MeasureSpec.makeMeasureSpec(AIOUtils.a(375.0F, getResources()), 1073741824), View.MeasureSpec.makeMeasureSpec(AIOUtils.a(667.0F, getResources()), 1073741824));
        ((ViewGroup)localObject1).layout(0, 0, ((ViewGroup)localObject1).getMeasuredWidth(), ((ViewGroup)localObject1).getMeasuredHeight());
        this.jdField_a_of_type_AndroidGraphicsBitmap = a((View)localObject1);
        paramView = (ImageView)paramView.findViewById(2131363511);
        localObject1 = RoundedBitmapDrawableFactory.create(getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap);
        ((RoundedBitmapDrawable)localObject1).setCornerRadius(AIOUtils.a(10.0F, getResources()));
        paramView.setImageDrawable((Drawable)localObject1);
      }
    }
    getArguments();
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketShareFragment", 2, "showWaitingDialog");
    }
    if ((getActivity() == null) || (getActivity().isFinishing()) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketShareFragment", 2, "showWaitingDialog, activity is finishing or dlg showing");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getResources().getDimensionPixelSize(2131558448));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getActivity().getString(2131429624));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketShareFragment", 2, "dismissWaittingDialog");
    }
    if ((getActivity() != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!getActivity().isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected int a()
  {
    return 2130969349;
  }
  
  public void a(Activity paramActivity)
  {
    super.a(paramActivity);
    paramActivity.getWindow().setFlags(1024, 1024);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketShareFragment", 2, "onNewRedPacketGameStart");
    }
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getActivity() != null) && ((getActivity().getAppInterface() instanceof VideoAppInterface))) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)getActivity().getAppInterface());
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131363687: 
    case 2131363688: 
    case 2131364328: 
    case 2131364329: 
    case 2131366245: 
      do
      {
        return;
        a(0);
        return;
        a(1);
        return;
        a(2);
        return;
        a(3);
        return;
      } while (!this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        QQToast.a(BaseApplication.getContext(), 1, 2131439090, 0).a();
        return;
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        q_();
        return;
      }
      QQToast.a(BaseApplication.getContext(), 0, "已保存", 0).a();
      return;
    }
    getActivity().onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      ((AVRedPacketManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(6)).a(this);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    a(paramLayoutInflater);
    b(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onStop()
  {
    super.onStop();
    d();
  }
  
  void q_()
  {
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.postImmediately(new jme(this), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketShareFragment
 * JD-Core Version:    0.7.0.1
 */