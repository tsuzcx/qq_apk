import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

class apyg
  implements aufy<EmoticonPackage>
{
  apyg(apyf paramapyf, bdrk parambdrk, boolean paramBoolean, apro paramapro, ProgressButton paramProgressButton, int paramInt) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool = false;
    int i = ((amca)this.jdField_a_of_type_Apyf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).g();
    Object localObject2 = "vip";
    Object localObject1 = "";
    Object localObject3;
    if (this.jdField_a_of_type_Bdrk.n == 4)
    {
      localObject1 = "mvip.g.a.bq_" + this.jdField_a_of_type_Bdrk.a;
      if (this.jdField_a_of_type_Bdrk.o != 4) {
        break label376;
      }
      localObject3 = "!vip";
      if (i != 1)
      {
        localObject2 = localObject3;
        if (i != 3) {}
      }
      else
      {
        bool = true;
        localObject2 = localObject3;
      }
      label104:
      localObject3 = new EmoticonPackage();
      ((EmoticonPackage)localObject3).jobType = this.jdField_a_of_type_Bdrk.n;
      ((EmoticonPackage)localObject3).epId = this.jdField_a_of_type_Bdrk.a;
      if (paramEmoticonPackage == null) {
        break label1002;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "canDownload:" + bool + ",vipType:" + i + ",isPayBack:" + this.jdField_a_of_type_Boolean);
      }
      if (apyf.a(this.jdField_a_of_type_Apyf, this.jdField_a_of_type_Bdrk))
      {
        this.jdField_a_of_type_Apro.a(paramEmoticonPackage.epId);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(this.jdField_a_of_type_Bdrk.d);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress(0);
        if (this.jdField_a_of_type_Boolean) {
          azqs.b(this.jdField_a_of_type_Apyf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800581D", 0, 0, this.jdField_a_of_type_Bdrk.a, "", "", "");
        }
      }
      label376:
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Bdrk.n == 0)
          {
            localObject1 = "mvip.g.a.bq_" + this.jdField_a_of_type_Bdrk.a;
            break;
          }
          if ((this.jdField_a_of_type_Bdrk.n != 3) && (this.jdField_a_of_type_Bdrk.n != 5)) {
            break;
          }
          localObject1 = "mvip.g.a.bq_mg_" + this.jdField_a_of_type_Bdrk.a;
          break;
          if (this.jdField_a_of_type_Bdrk.o == 5)
          {
            localObject3 = "!svip";
            localObject2 = localObject3;
            if (i != 3) {
              break label104;
            }
            bool = true;
            localObject2 = localObject3;
            break label104;
          }
          bool = true;
          break label104;
          azqs.b(this.jdField_a_of_type_Apyf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005817", 0, 0, this.jdField_a_of_type_Bdrk.a, "", "", "");
          return;
          if (bool)
          {
            localObject1 = (alrp)this.jdField_a_of_type_Apyf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
            if (this.jdField_a_of_type_Int == 1)
            {
              ((alrp)localObject1).a(paramEmoticonPackage.epId, this.jdField_a_of_type_Int);
              this.jdField_a_of_type_Apro.a(paramEmoticonPackage, true, this.jdField_a_of_type_Int);
              this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(alud.a(2131713656));
              this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgressDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.a(-16745986));
              if (!this.jdField_a_of_type_Boolean) {
                azqs.b(this.jdField_a_of_type_Apyf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005814", 0, 0, this.jdField_a_of_type_Bdrk.a, "", "", "");
              }
              localObject1 = this.jdField_a_of_type_Apyf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject2 = this.jdField_a_of_type_Bdrk.a;
              if (!this.jdField_a_of_type_Apyf.jdField_a_of_type_Boolean) {
                break label805;
              }
              paramEmoticonPackage = "1";
              azqs.b((QQAppInterface)localObject1, "CliOper", "", "", "ep_mall", "0X8006139", 0, 0, (String)localObject2, paramEmoticonPackage, "", "");
              i = this.jdField_a_of_type_Apyf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
              int j = this.jdField_a_of_type_Apyf.jdField_a_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_Bdrk);
              localObject1 = this.jdField_a_of_type_Apyf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
              localObject2 = this.jdField_a_of_type_Bdrk.a;
              localObject3 = j + 1 + "";
              if (!this.jdField_a_of_type_Apyf.jdField_a_of_type_Boolean) {
                break label811;
              }
            }
            for (paramEmoticonPackage = "1";; paramEmoticonPackage = "")
            {
              VasWebviewUtil.reportCommercialDrainage((String)localObject1, "ep_mall", "0X8005814", "", 0, 0, 0, "", (String)localObject2, (String)localObject3, paramEmoticonPackage, "", i + "", "", 0, 0, 0, 0);
              return;
              if (paramEmoticonPackage.type == 4) {
                break;
              }
              ((alrp)localObject1).a(paramEmoticonPackage.epId, this.jdField_a_of_type_Int);
              break;
              paramEmoticonPackage = "";
              break label609;
            }
          }
        } while (this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_Apyf.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton;
        paramEmoticonPackage = "https://mc.vip.qq.com/qqwallet/index?aid=" + (String)localObject1 + "&type=" + (String)localObject2 + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk&debug=1";
        localObject1 = new Intent(this.jdField_a_of_type_Apyf.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramEmoticonPackage);
      } while (!(this.jdField_a_of_type_Apyf.jdField_a_of_type_AndroidContentContext instanceof Activity));
      label609:
      ((Activity)this.jdField_a_of_type_Apyf.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject1, 4779);
      label805:
      label811:
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "func downloadOrPay. mCurPageIndex: epid = " + this.jdField_a_of_type_Bdrk.a);
      }
      azqs.b(this.jdField_a_of_type_Apyf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005815", 0, 0, this.jdField_a_of_type_Bdrk.a, "", "", "");
      return;
      label1002:
      paramEmoticonPackage = (EmoticonPackage)localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apyg
 * JD-Core Version:    0.7.0.1
 */