import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Parcelable;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.XListView;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import mqq.app.MobileQQ;

public class an
  implements View.OnClickListener
{
  public an(LiteActivity paramLiteActivity, DataLineMsgRecord paramDataLineMsgRecord, DataLineMsgSet paramDataLineMsgSet, Context paramContext, int paramInt, String paramString, boolean paramBoolean) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    if (2131375350 == paramView.getId())
    {
      StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getCurrentAccountUin(), "dl_copy");
      ((ClipboardManager)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXListView.getContext().getSystemService("clipboard")).setText(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msg);
    }
    label397:
    do
    {
      return;
      Object localObject1;
      if (2131375341 == paramView.getId())
      {
        StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getCurrentAccountUin(), "dl_delete");
        paramView = new ao(this);
        localObject1 = new ap(this);
        DialogUtil.b(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131427500), this.jdField_a_of_type_AndroidContentContext.getString(2131427526), 2131432998, 2131427501, paramView, (DialogInterface.OnClickListener)localObject1).show();
        return;
      }
      long l;
      Object localObject2;
      int i;
      if (2131363499 == paramView.getId())
      {
        StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getCurrentAccountUin(), "dl_forward");
        if (this.jdField_a_of_type_Int == -1000)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("forward_text", new QQText(paramView.msg, 13, 32, 6000).toString());
          ((Intent)localObject1).putExtra("forward_type", -1);
          ((Intent)localObject1).putExtra("isFromShare", true);
          ForwardBaseOption.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, (Intent)localObject1, 4);
          return;
        }
        if (FileUtils.b(this.jdField_a_of_type_JavaLangString))
        {
          l = FileUtils.a(this.jdField_a_of_type_JavaLangString);
          paramView = FileManagerUtil.a(this.jdField_a_of_type_JavaLangString);
          localObject1 = new ForwardFileInfo();
          ((ForwardFileInfo)localObject1).b(10000);
          ((ForwardFileInfo)localObject1).d(6);
          ((ForwardFileInfo)localObject1).d(paramView);
          ((ForwardFileInfo)localObject1).d(l);
          ((ForwardFileInfo)localObject1).a(this.jdField_a_of_type_JavaLangString);
          ((ForwardFileInfo)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.entityID);
          localObject2 = new Intent();
          if (this.jdField_a_of_type_Boolean)
          {
            ((Intent)localObject2).putExtra("forward_text", paramView);
            if (!this.jdField_a_of_type_Boolean) {
              break label519;
            }
            i = 1;
            ((Intent)localObject2).putExtra("forward_type", i);
            ((Intent)localObject2).putExtra("forward_filepath", this.jdField_a_of_type_JavaLangString);
            ((Intent)localObject2).putExtra("fileinfo", (Parcelable)localObject1);
            ((Intent)localObject2).putExtra("not_forward", true);
            ((Intent)localObject2).putExtra("isFromShare", true);
            if (!this.jdField_a_of_type_Boolean) {
              break label524;
            }
            ((Intent)localObject2).putExtra("forward_thumb", this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.path);
          }
          for (;;)
          {
            ForwardBaseOption.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, (Intent)localObject2, 4);
            return;
            paramView = "已选择" + paramView + "，大小" + FileUtil.a(l) + "。";
            break;
            i = 0;
            break label397;
            ((Intent)localObject2).putExtra("k_favorites", false);
          }
        }
        FileManagerUtil.a(FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, 10009);
        return;
      }
      if (2131366733 == paramView.getId())
      {
        if (this.jdField_a_of_type_JavaLangString.isEmpty())
        {
          QfavBuilder.a(null, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msg).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getActivity(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount());
          QfavReport.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, 64, 1);
          return;
        }
        QfavBuilder.b(this.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getActivity(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount());
        QfavReport.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, 64, 3);
        return;
      }
      if (2131375351 == paramView.getId())
      {
        StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getCurrentAccountUin(), "dl_save2weiyun");
        l = FileUtils.a(this.jdField_a_of_type_JavaLangString);
        localObject1 = FileManagerUtil.a(this.jdField_a_of_type_JavaLangString);
        paramView = null;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
        if (((DataLineMsgRecord)localObject2).nWeiyunSessionId != 0L) {
          paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(((DataLineMsgRecord)localObject2).nWeiyunSessionId);
        }
        if ((FileManagerUtil.a()) && (l > FMConfig.a()))
        {
          FMDialogUtil.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getActivity(), 2131428241, 2131428238, new aq(this, (DataLineMsgRecord)localObject2, paramView, (String)localObject1));
          return;
        }
        if (paramView == null)
        {
          i = DataLineMsgRecord.getDevTypeBySeId(((DataLineMsgRecord)localObject2).sessionid);
          FMToastUtil.b(FileManagerUtil.d((String)localObject1) + this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131428194));
          ((DataLineMsgRecord)localObject2).nWeiyunSessionId = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(this.jdField_a_of_type_JavaLangString, null, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount(), 0, false).nSessionId;
          this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(i).c(((DataLineMsgRecord)localObject2).msgId);
          return;
        }
        FMToastUtil.b(FileManagerUtil.d((String)localObject1) + this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131428194));
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(((DataLineMsgRecord)localObject2).nWeiyunSessionId);
        return;
      }
      if (2131361852 == paramView.getId())
      {
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet);
        return;
      }
    } while (2131375382 != paramView.getId());
    label519:
    label524:
    ReportController.b(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    paramView = new TeamWorkFileImportInfo();
    paramView.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.path;
    paramView.b = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.filename;
    paramView.d = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.filename);
    paramView.jdField_a_of_type_Int = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramView.jdField_c_of_type_Int = 1;
    paramView.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.filesize;
    TeamWorkConvertUtils.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     an
 * JD-Core Version:    0.7.0.1
 */