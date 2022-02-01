package com.tencent.mobileqq.activity;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.ServerNotifyObserver;

class VerifyCodeActivity$1
  extends ServerNotifyObserver
{
  VerifyCodeActivity$1(VerifyCodeActivity paramVerifyCodeActivity) {}
  
  public void onReceiveVerifyCode(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
  {
    QLog.d("VerifyCodeActivity", 1, "onReceiveVerifyCode");
    paramString2 = this.a;
    paramString2.isRefresh = false;
    if (paramString2.isSend)
    {
      this.a.ed.setText("");
      QQToast.makeText(this.a.getApplicationContext(), 1, this.a.getString(2131917817), 0).show();
    }
    this.a.serverNotifyObserver.setKey(paramString1);
    this.a.serverNotifyObserver.setSeq(paramInt);
    this.a.tvRefresh.setEnabled(true);
    if ((this.a.ed.getText().toString() != null) && (this.a.ed.getText().toString().length() > 4)) {
      VerifyCodeActivity.access$000(this.a, true);
    }
    if (paramArrayOfByte != null)
    {
      this.a.mVerifyCodeImageView.setImageBitmap(BitmapManager.a(paramArrayOfByte, 0, paramArrayOfByte.length));
      this.a.showWaitting(false);
      return;
    }
    Toast.makeText(this.a.getApplicationContext(), this.a.getString(2131917814), 1).show();
  }
  
  public void onVerifyClose()
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyCodeActivity.1
 * JD-Core Version:    0.7.0.1
 */