import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

public class bdjb
{
  private bdin jdField_a_of_type_Bdin;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  private AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  
  public bdjb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bdin);
  }
  
  private AbsStructMsg a(Context paramContext, String paramString)
  {
    String str3 = atvo.a(paramString);
    String str1 = atwl.a(paramString);
    if (bdjg.jdField_a_of_type_JavaLangString.indexOf(str1) < 0)
    {
      QLog.e("TeamWorkSender", 1, paramString + " is not docs support file");
      return null;
    }
    if (".doc|.docx".contains(str1)) {
      paramString = anni.a(2131713486);
    }
    for (str1 = "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png";; str1 = "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png")
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_flag_from_plugin", true);
      localIntent.setClass(paramContext, ForwardRecentActivity.class);
      localIntent.putExtra("isFromShare", true);
      localIntent.putExtra("forward_type", 1001);
      localIntent.putExtra("pluginName", "web_share");
      localIntent.putExtra("req_type", 95);
      localIntent.putExtra("image_url_remote", str1);
      localIntent.putExtra("pubUin", "");
      localIntent.putExtra("struct_uin", "");
      String str2 = str3;
      if (str3 != null)
      {
        str2 = str3;
        if (str3.length() > 45) {
          str2 = str3.substring(0, 45) + "…";
        }
      }
      localIntent.putExtra("title", str2);
      str3 = paramString;
      if (paramString != null)
      {
        str3 = paramString;
        if (paramString.length() > 60) {
          str3 = paramString.substring(0, 60) + "…";
        }
      }
      localIntent.putExtra("desc", str3);
      localIntent.putExtra("forward_thumb", str1);
      localIntent.putExtra("struct_share_key_content_action", "web");
      localIntent.putExtra("req_share_id", -1L);
      localIntent.putExtra("struct_share_key_source_action", "web");
      localIntent.putExtra("struct_share_key_source_url", "https://docs.qq.com/desktop/m/index.html?_wv=2");
      localIntent.putExtra("struct_share_key_source_icon", "https://docs.qq.com/desktop/favicon.ico");
      localIntent.putExtra("app_name", anni.a(2131713505));
      localIntent.putExtra("brief_key", paramContext.getString(2131695697, new Object[] { str2 }));
      return bcwd.a(localIntent.getExtras());
      paramString = anni.a(2131713482);
    }
  }
  
  private TeamWorkFileImportInfo a(MessageRecord paramMessageRecord)
  {
    try
    {
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("fileName");
      QLog.i("TeamWorkSender", 1, "dmytest");
      localTeamWorkFileImportInfo.c = paramMessageRecord.getExtInfoFromExtStr("filePath");
      localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("peerUin");
      localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troopFilePath");
      localTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troopUin");
      localTeamWorkFileImportInfo.jdField_d_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("entranceFrom"));
      localTeamWorkFileImportInfo.jdField_j_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("fileImportType"));
      localTeamWorkFileImportInfo.jdField_d_of_type_Long = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("fileSize"));
      localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isFromAIO"));
      localTeamWorkFileImportInfo.f = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isMessageConvert"));
      localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isNeedDownLoadUrl"));
      localTeamWorkFileImportInfo.jdField_d_of_type_Boolean = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isOpenTeamWork"));
      localTeamWorkFileImportInfo.jdField_e_of_type_Boolean = Boolean.parseBoolean(paramMessageRecord.getExtInfoFromExtStr("isUserClick"));
      localTeamWorkFileImportInfo.jdField_a_of_type_Long = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("msgUniseq"));
      localTeamWorkFileImportInfo.jdField_e_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("nFileType"));
      localTeamWorkFileImportInfo.jdField_b_of_type_Long = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("nSessionId"));
      localTeamWorkFileImportInfo.jdField_a_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("peerType"));
      localTeamWorkFileImportInfo.jdField_b_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troopFileBusId"));
      localTeamWorkFileImportInfo.jdField_e_of_type_Long = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("structUniseq"));
      return localTeamWorkFileImportInfo;
    }
    catch (Exception paramMessageRecord)
    {
      QLog.e("TeamWorkSender", 1, "parse mr info is error");
    }
    return null;
  }
  
  private TeamWorkFileImportInfo a(FileManagerEntity paramFileManagerEntity)
  {
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    localTeamWorkFileImportInfo.c = paramFileManagerEntity.getFilePath();
    localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = paramFileManagerEntity.fileName;
    localTeamWorkFileImportInfo.jdField_e_of_type_Int = paramFileManagerEntity.nFileType;
    localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = false;
    localTeamWorkFileImportInfo.jdField_d_of_type_Int = 4;
    localTeamWorkFileImportInfo.jdField_d_of_type_Long = paramFileManagerEntity.fileSize;
    localTeamWorkFileImportInfo.jdField_a_of_type_Int = paramFileManagerEntity.peerType;
    localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = paramFileManagerEntity.peerUin;
    localTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = String.valueOf(paramFileManagerEntity.TroopUin);
    localTeamWorkFileImportInfo.jdField_b_of_type_Int = paramFileManagerEntity.busId;
    localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = paramFileManagerEntity.strTroopFilePath;
    localTeamWorkFileImportInfo.jdField_a_of_type_Long = paramFileManagerEntity.uniseq;
    if (paramFileManagerEntity.status != 16) {
      localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
    }
    return localTeamWorkFileImportInfo;
  }
  
  private TeamWorkFileImportInfo a(String paramString)
  {
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    localTeamWorkFileImportInfo.c = paramString;
    localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = atvo.a(paramString);
    localTeamWorkFileImportInfo.jdField_e_of_type_Int = atvo.a(paramString);
    localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = false;
    localTeamWorkFileImportInfo.jdField_d_of_type_Int = 4;
    localTeamWorkFileImportInfo.jdField_d_of_type_Long = atvo.a(paramString);
    localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = false;
    return localTeamWorkFileImportInfo;
  }
  
  private String a(int paramInt)
  {
    anni.a(2131713484);
    switch (paramInt)
    {
    case -109: 
    case -105: 
    case -104: 
    default: 
      return anni.a(2131713460);
    case -102: 
    case -101: 
    case -100: 
      return anni.a(2131713450);
    case -103: 
      return anni.a(2131713480);
    case -116: 
    case -106: 
      return anni.a(2131713478);
    case -107: 
      return anni.a(2131713442);
    case -108: 
      return anni.a(2131713494);
    case -110: 
      return anni.a(2131713481);
    case -111: 
      return anni.a(2131713463);
    case -115: 
    case -113: 
    case -112: 
      return anni.a(2131713447);
    }
    return anni.a(2131713503);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Bdin = new bdjc(this);
  }
  
  private void a(MessageRecord paramMessageRecord, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    paramMessageRecord.saveExtInfoToExtStr("fileName", paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString);
    paramMessageRecord.saveExtInfoToExtStr("filePath", paramTeamWorkFileImportInfo.c);
    paramMessageRecord.saveExtInfoToExtStr("peerUin", paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
    if (paramTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString != null) {}
    for (String str = paramTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString;; str = "")
    {
      paramMessageRecord.saveExtInfoToExtStr("troopFilePath", str);
      paramMessageRecord.saveExtInfoToExtStr("troopUin", paramTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString);
      paramMessageRecord.saveExtInfoToExtStr("entranceFrom", String.valueOf(paramTeamWorkFileImportInfo.jdField_d_of_type_Int));
      paramMessageRecord.saveExtInfoToExtStr("fileImportType", String.valueOf(paramTeamWorkFileImportInfo.jdField_j_of_type_Int));
      paramMessageRecord.saveExtInfoToExtStr("fileSize", String.valueOf(paramTeamWorkFileImportInfo.jdField_d_of_type_Long));
      paramMessageRecord.saveExtInfoToExtStr("isFromAIO", String.valueOf(paramTeamWorkFileImportInfo.jdField_b_of_type_Boolean));
      paramMessageRecord.saveExtInfoToExtStr("isMessageConvert", String.valueOf(paramTeamWorkFileImportInfo.f));
      paramMessageRecord.saveExtInfoToExtStr("isNeedDownLoadUrl", String.valueOf(paramTeamWorkFileImportInfo.jdField_a_of_type_Boolean));
      paramMessageRecord.saveExtInfoToExtStr("isOpenTeamWork", String.valueOf(paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean));
      paramMessageRecord.saveExtInfoToExtStr("isUserClick", String.valueOf(paramTeamWorkFileImportInfo.jdField_e_of_type_Boolean));
      paramMessageRecord.saveExtInfoToExtStr("msgUniseq", String.valueOf(paramTeamWorkFileImportInfo.jdField_a_of_type_Long));
      paramMessageRecord.saveExtInfoToExtStr("nFileType", String.valueOf(paramTeamWorkFileImportInfo.jdField_e_of_type_Int));
      paramMessageRecord.saveExtInfoToExtStr("nSessionId", String.valueOf(paramTeamWorkFileImportInfo.jdField_b_of_type_Long));
      paramMessageRecord.saveExtInfoToExtStr("peerType", String.valueOf(paramTeamWorkFileImportInfo.jdField_a_of_type_Int));
      paramMessageRecord.saveExtInfoToExtStr("troopFileBusId", String.valueOf(paramTeamWorkFileImportInfo.jdField_b_of_type_Int));
      paramMessageRecord.saveExtInfoToExtStr("structUniseq", String.valueOf(paramTeamWorkFileImportInfo.jdField_e_of_type_Long));
      paramMessageRecord.saveExtInfoToExtStr("strSendUin", paramTeamWorkFileImportInfo.jdField_j_of_type_JavaLangString);
      paramMessageRecord.saveExtInfoToExtStr("import_file_message_flag", "import_file_message_flag_value");
      return;
    }
  }
  
  private void a(AbsStructMsg paramAbsStructMsg, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString, int paramInt)
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    int i = bbxc.jdField_a_of_type_Int;
    bbxc.jdField_a_of_type_Int = i + 1;
    long l = i;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (TextUtils.isEmpty(paramString)) {}
    for (String str1 = str2;; str1 = paramString)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = bbzh.a(localQQAppInterface, str2, paramString, str1, paramInt, l, paramAbsStructMsg);
      paramTeamWorkFileImportInfo.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq;
      a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, paramTeamWorkFileImportInfo);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.issend = 1;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.extraflag = 32772;
      paramAbsStructMsg.addFlag(1);
      paramAbsStructMsg.addFlag(2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, 0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, str2);
      paramAbsStructMsg = (bdia)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(120);
      if (!TextUtils.isEmpty(paramAbsStructMsg.a(paramTeamWorkFileImportInfo))) {
        paramAbsStructMsg.a(paramTeamWorkFileImportInfo);
      }
      if (!paramAbsStructMsg.a(paramTeamWorkFileImportInfo))
      {
        paramAbsStructMsg.a(paramTeamWorkFileImportInfo);
        QLog.i("TeamWorkSender", 1, "start import file:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq);
        if (QLog.isColorLevel()) {
          QLog.i("TeamWorkSender", 1, "start Import File: " + paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString);
        }
      }
      return;
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = a(BaseActivity.sTopActivity, paramFileManagerEntity.fileName);
    paramFileManagerEntity = a(paramFileManagerEntity);
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg, paramFileManagerEntity, paramString2, paramInt);
      atvm.a("0X800942C");
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramString2 = atvo.a(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = a(BaseActivity.sTopActivity, paramString2);
    paramString1 = a(paramString1);
    paramString1.jdField_a_of_type_Int = paramInt;
    paramString1.jdField_a_of_type_JavaLangString = paramString3;
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg, paramString1, paramString3, paramInt);
      atvm.a("0X800942C");
    }
  }
  
  public boolean a(MessageForStructing paramMessageForStructing, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = paramMessageForStructing.structingMsg;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = paramMessageForStructing;
    paramSessionInfo = a(paramMessageForStructing);
    if (paramSessionInfo == null) {
      return false;
    }
    if (paramSessionInfo.jdField_e_of_type_Long == 0L) {
      paramSessionInfo.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uniseq;
    }
    bdia localbdia = (bdia)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(120);
    if (!TextUtils.isEmpty(localbdia.a(paramSessionInfo))) {
      localbdia.a(paramSessionInfo);
    }
    if (!localbdia.a(paramSessionInfo)) {
      localbdia.a(paramSessionInfo);
    }
    QLog.i("TeamWorkSender", 1, "structsg resend:" + paramMessageForStructing.uniseq);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjb
 * JD-Core Version:    0.7.0.1
 */