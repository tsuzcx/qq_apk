import QC.BubbleRsp;
import QC.CommonRsp;
import QC.FontRsp;
import QC.SetFontBubbleRsp;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.hiboom.FontBubble;
import com.tencent.mobileqq.hiboom.FontBubbleManager.1;
import com.tencent.mobileqq.hiboom.FontBubbleManager.2;
import com.tencent.mobileqq.hiboom.FontBubblePanelView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.net.URLEncoder;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class asrm
  implements Handler.Callback
{
  private alwx jdField_a_of_type_Alwx = new asrp(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private assy jdField_a_of_type_Assy;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private long[] jdField_a_of_type_ArrayOfLong;
  private assy b;
  
  public asrm(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alwx);
  }
  
  public static asrm a(QQAppInterface paramQQAppInterface)
  {
    return ((bduj)paramQQAppInterface.getManager(235)).a;
  }
  
  private void a(Context paramContext)
  {
    QQToast.a(paramContext, 0, alud.a(2131705066), 2000).a();
    int j;
    if (this.b != null)
    {
      paramContext = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      j = this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.panelType;
      if (j != 3) {
        break label107;
      }
    }
    label107:
    for (int i = this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.fontId;; i = this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.bubbleId)
    {
      VasWebviewUtil.reportCommercialDrainage(paramContext, "aio_iconA", "Send", "", 1, 0, 0, "", Integer.toString(i), FontBubblePanelView.a(j), "1", "", "", "", 0, 0, 0, 0);
      this.b = null;
      this.jdField_a_of_type_Assy = null;
      return;
    }
  }
  
  private void a(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontBubbleManager", 2, "sendMsg");
    }
    String str = paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if (TextUtils.isEmpty(str)) {
      QLog.e("FontBubbleManager", 1, "sendMsg fail input is empty");
    }
    do
    {
      return;
      acjt localacjt = new acjt();
      paramBaseChatPie.a(localacjt);
      localacjt.i = paramBaseChatPie.J;
      paramBaseChatPie.J = false;
      this.jdField_a_of_type_ArrayOfLong = acjm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.a(), paramBaseChatPie.a(), str, new ArrayList(), localacjt);
      paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
      paramBaseChatPie.aE();
    } while (this.b == null);
    int j = this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.panelType;
    if (j == 3) {}
    for (int i = this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.fontId;; i = this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.bubbleId)
    {
      VasWebviewUtil.reportCommercialDrainage(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "aio_iconA", "Send", "", 1, 0, 0, "", Integer.toString(i), FontBubblePanelView.a(j), "0", "", "", "", 0, 0, 0, 0);
      this.b = null;
      return;
    }
  }
  
  private void a(BaseChatPie paramBaseChatPie, long paramLong, int paramInt)
  {
    FontBubble localFontBubble = this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble;
    Object localObject2 = localFontBubble.title;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = alud.a(2131705067);
    }
    Object localObject3 = localFontBubble.msg;
    localObject2 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject2 = "开通QQ会员即可使用该气泡";
    }
    String str = localFontBubble.btn;
    localObject3 = str;
    if (TextUtils.isEmpty(str)) {
      localObject3 = "开通QQ会员";
    }
    str = URLEncoder.encode("jsbridge://font/fontBubblePaySuccess?p={\"sid\":" + paramLong + ",\"id\":" + paramInt + "}");
    str = localFontBubble.payUrl + "&return_url=" + str;
    if (QLog.isColorLevel()) {
      QLog.d("FontBubbleManager", 2, "url: " + str);
    }
    bdgm.a(paramBaseChatPie.a(), 230, (String)localObject1, (CharSequence)localObject2, alud.a(2131705068), (String)localObject3, new asrn(this, paramBaseChatPie, str), new asro(this)).show();
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (this.b != null)
    {
      if (paramInt1 == 5L) {
        if (paramInt2 != this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.fontId) {}
      }
      while (paramInt2 == this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.bubbleId)
      {
        return true;
        return false;
      }
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(paramInt1).append(", ").append(paramInt2).append(" is not currentSelect: ");
    if (this.b == null) {}
    for (Object localObject = "null";; localObject = this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble)
    {
      QLog.e("FontBubbleManager", 1, localObject);
      return false;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alwx);
  }
  
  public void a(long paramLong)
  {
    long[] arrayOfLong;
    int j;
    int i;
    if (this.jdField_a_of_type_ArrayOfLong != null)
    {
      arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
      j = arrayOfLong.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if (arrayOfLong[i] != paramLong) {
          break label59;
        }
        this.jdField_a_of_type_ArrayOfLong = null;
        if (this.jdField_a_of_type_Assy != null) {
          this.jdField_a_of_type_Assy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      return;
      label59:
      i += 1;
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, Bundle paramBundle)
  {
    int i = paramBundle.getInt("sid");
    int j = paramBundle.getInt("id");
    boolean bool = a(i, j);
    if (QLog.isColorLevel()) {
      QLog.d("FontBubbleManager", 2, "onFontBubblePaySuccess: " + i + "," + j + "," + bool);
    }
    if (this.b != null)
    {
      i = this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.panelType;
      VasWebviewUtil.reportCommercialDrainage(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "aio_iconA", "OpenSvip", "", 1, 0, 0, "", "", FontBubblePanelView.a(i));
      this.b = new assy(this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble);
      this.b.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, boolean paramBoolean, SetFontBubbleRsp paramSetFontBubbleRsp, int paramInt)
  {
    if ((paramBoolean) && (paramSetFontBubbleRsp.stRet != null) && (paramSetFontBubbleRsp.stRet.ret == 0))
    {
      if ((this.b != null) && (this.b.jdField_a_of_type_Int == paramInt))
      {
        if (((this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.panelType == 3) && (paramSetFontBubbleRsp.stFontRsp.authRet == 0)) || ((this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.panelType == 4) && (paramSetFontBubbleRsp.stBubbleRsp.authRet == 0)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FontBubbleManager", 2, "onSetFontBubble mClick success: " + this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble);
          }
          ThreadManagerV2.excute(new FontBubbleManager.2(this, paramBaseChatPie), 32, null, true);
          return;
        }
        QLog.e("FontBubbleManager", 1, "onSetFontBubble mClick fail: " + paramSetFontBubbleRsp.stFontRsp.authRet + "," + paramSetFontBubbleRsp.stBubbleRsp.authRet + this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble);
        if ((paramSetFontBubbleRsp.stFontRsp.authRet < 0) || (paramSetFontBubbleRsp.stBubbleRsp.authRet < 0))
        {
          a(paramBaseChatPie.a());
          return;
        }
        if (this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.panelType == 3)
        {
          a(paramBaseChatPie, 5L, paramSetFontBubbleRsp.stFontRsp.fontID);
          return;
        }
        a(paramBaseChatPie, 2L, paramSetFontBubbleRsp.stBubbleRsp.bubbleID);
        return;
      }
      if ((this.jdField_a_of_type_Assy != null) && (this.jdField_a_of_type_Assy.jdField_a_of_type_Int == paramInt))
      {
        if ((paramSetFontBubbleRsp.stFontRsp.authRet != 0) || (paramSetFontBubbleRsp.stBubbleRsp.authRet != 0)) {
          QLog.e("FontBubbleManager", 1, "onSetFontBubble failed," + " fontAuth:" + paramSetFontBubbleRsp.stFontRsp.authRet + " bubbleAuth:" + paramSetFontBubbleRsp.stBubbleRsp.authRet + this.jdField_a_of_type_Assy.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble);
        }
        for (;;)
        {
          this.jdField_a_of_type_Assy = null;
          return;
          if (QLog.isColorLevel()) {
            QLog.d("FontBubbleManager", 2, "onSetFontBubble mRestore success: " + this.jdField_a_of_type_Assy.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble);
          }
        }
      }
      QLog.e("FontBubbleManager", 1, "onSetFontBubble seq out of date," + paramSetFontBubbleRsp.stFontRsp.fontID + "," + paramSetFontBubbleRsp.stBubbleRsp.bubbleID + " fontAuth:" + paramSetFontBubbleRsp.stFontRsp.authRet + " bubbleAuth:" + paramSetFontBubbleRsp.stBubbleRsp.authRet);
      return;
    }
    StringBuilder localStringBuilder = aepi.a().append("onSetFontBubble failed,");
    if ((paramSetFontBubbleRsp != null) && (paramSetFontBubbleRsp.stRet != null))
    {
      localStringBuilder.append(paramSetFontBubbleRsp.stFontRsp.fontID).append(",").append(paramSetFontBubbleRsp.stBubbleRsp.bubbleID);
      localStringBuilder.append(" ret:");
      localStringBuilder.append(paramSetFontBubbleRsp.stRet.ret);
      localStringBuilder.append("err:");
      localStringBuilder.append(paramSetFontBubbleRsp.stRet.err);
    }
    QLog.e("FontBubbleManager", 1, localStringBuilder.toString());
    if ((this.b != null) && (this.b.jdField_a_of_type_Int == paramInt)) {
      QLog.e("FontBubbleManager", 1, "click failed: " + this.b.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble);
    }
    if ((this.jdField_a_of_type_Assy != null) && (this.jdField_a_of_type_Assy.jdField_a_of_type_Int == paramInt)) {
      QLog.e("FontBubbleManager", 1, "restore failed: " + this.jdField_a_of_type_Assy.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble);
    }
    a(paramBaseChatPie.a());
  }
  
  public void a(FontBubble paramFontBubble)
  {
    ThreadManagerV2.excute(new FontBubbleManager.1(this, paramFontBubble), 32, null, true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1000: 
      paramMessage = (Object[])paramMessage.obj;
      this.jdField_a_of_type_Assy = new assy((FontBubble)paramMessage[0]);
      this.b = new assy((FontBubble)paramMessage[1]);
      this.b.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return true;
    }
    a((BaseChatPie)paramMessage.obj);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asrm
 * JD-Core Version:    0.7.0.1
 */