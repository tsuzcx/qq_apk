import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Parcelable;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import mqq.app.MobileQQ;

public class az
  implements View.OnClickListener
{
  public az(LiteActivity paramLiteActivity, DataLineMsgRecord paramDataLineMsgRecord, DataLineMsgSet paramDataLineMsgSet, Context paramContext, int paramInt, String paramString, boolean paramBoolean) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    int i;
    if (2131365250 == paramView.getId())
    {
      bdlq.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getCurrentAccountUin(), "dl_copy");
      ((ClipboardManager)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXListView.getContext().getSystemService("clipboard")).setText(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msg);
      i = LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity);
      bdla.b(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, "dc00898", "", "", "0X800AD63", "0X800AD63", 1, 0, "" + i, "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1;
      Object localObject2;
      int j;
      if (2131365484 == paramView.getId())
      {
        bdlq.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getCurrentAccountUin(), "dl_delete");
        localObject1 = new ba(this);
        localObject2 = new bb(this);
        bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131693616), this.jdField_a_of_type_AndroidContentContext.getString(2131693595), 2131690697, 2131693635, (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject2).show();
        i = LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, this.jdField_a_of_type_Int);
        j = LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity);
        bdla.b(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, "dc00898", "", "", "0X800AD5D", "0X800AD5D", i, 0, "" + j, "", "", "");
      }
      else
      {
        if (2131367213 == paramView.getId())
        {
          bdlq.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getCurrentAccountUin(), "dl_forward");
          if (this.jdField_a_of_type_Int == -1000)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("forward_text", new QQText(((DataLineMsgRecord)localObject1).msg, 13, 32, 6000).toString());
            ((Intent)localObject2).putExtra("forward_type", -1);
            ((Intent)localObject2).putExtra("isFromShare", true);
            ((Intent)localObject2).putExtra("isFromDataLineAIO", true);
            aupt.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, (Intent)localObject2, 4);
          }
          for (;;)
          {
            i = LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, this.jdField_a_of_type_Int);
            j = LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity);
            bdla.b(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, "dc00898", "", "", "0X800AD5B", "0X800AD5B", i, 0, "" + j, "", "", "");
            break;
            if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_JavaLangString))
            {
              long l = FileUtils.getFileSizes(this.jdField_a_of_type_JavaLangString);
              localObject1 = auea.a(this.jdField_a_of_type_JavaLangString);
              localObject2 = new ForwardFileInfo();
              ((ForwardFileInfo)localObject2).b(10000);
              ((ForwardFileInfo)localObject2).d(6);
              ((ForwardFileInfo)localObject2).d((String)localObject1);
              ((ForwardFileInfo)localObject2).d(l);
              if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.thumbPath))) {
                ((ForwardFileInfo)localObject2).f(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.thumbPath);
              }
              ((ForwardFileInfo)localObject2).a(this.jdField_a_of_type_JavaLangString);
              if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord != null) {
                ((ForwardFileInfo)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.entityID);
              }
              Intent localIntent = new Intent();
              if (this.jdField_a_of_type_Boolean)
              {
                label643:
                localIntent.putExtra("forward_text", (String)localObject1);
                if (!this.jdField_a_of_type_Boolean) {
                  break label818;
                }
                i = 1;
                label662:
                localIntent.putExtra("forward_type", i);
                localIntent.putExtra("forward_filepath", this.jdField_a_of_type_JavaLangString);
                localIntent.putExtra("fileinfo", (Parcelable)localObject2);
                localIntent.putExtra("not_forward", true);
                localIntent.putExtra("isFromShare", true);
                localIntent.putExtra("isFromDataLineAIO", true);
                if (!this.jdField_a_of_type_Boolean) {
                  break label823;
                }
                if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord != null) {
                  localIntent.putExtra("forward_thumb", this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.path);
                }
              }
              for (;;)
              {
                aupt.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, localIntent, 4);
                break;
                localObject1 = anvx.a(2131705676) + (String)localObject1 + anvx.a(2131705674) + FileUtil.filesizeToString(l) + "。";
                break label643;
                label818:
                i = 0;
                break label662;
                label823:
                localIntent.putExtra("k_favorites", false);
              }
            }
            auea.a(auea.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, 10009);
          }
        }
        if (2131366456 == paramView.getId())
        {
          if (this.jdField_a_of_type_JavaLangString.isEmpty())
          {
            bmad.a(null, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msg).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getActivity(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount());
            bman.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, 64, 1);
          }
          for (;;)
          {
            i = LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, this.jdField_a_of_type_Int);
            j = LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity);
            bdla.b(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, "dc00898", "", "", "0X800AD5C", "0X800AD5C", i, 0, "" + j, "", "", "");
            break;
            if (this.jdField_a_of_type_Int == -2000)
            {
              bmad.b(this.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getActivity(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount());
              bman.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, 64, 3);
            }
            else if ((this.jdField_a_of_type_Int == -2005) || (this.jdField_a_of_type_Int == -2009))
            {
              new bmad(3).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_JavaLangString);
            }
          }
        }
        if (2131380563 == paramView.getId())
        {
          LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
        }
        else if (2131362198 == paramView.getId())
        {
          LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, this.jdField_a_of_type_Int);
        }
        else if (2131378536 == paramView.getId())
        {
          bdla.b(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
          localObject1 = new TeamWorkFileImportInfo();
          ((TeamWorkFileImportInfo)localObject1).c = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.path;
          ((TeamWorkFileImportInfo)localObject1).b = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.filename;
          ((TeamWorkFileImportInfo)localObject1).e = auea.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.filename);
          ((TeamWorkFileImportInfo)localObject1).jdField_a_of_type_Int = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
          ((TeamWorkFileImportInfo)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
          ((TeamWorkFileImportInfo)localObject1).jdField_d_of_type_Int = 1;
          ((TeamWorkFileImportInfo)localObject1).jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.filesize;
          beaz.a((TeamWorkFileImportInfo)localObject1, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     az
 * JD-Core Version:    0.7.0.1
 */