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
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.widget.XListView;
import mqq.app.MobileQQ;

public class au
  implements View.OnClickListener
{
  public au(LiteActivity paramLiteActivity, DataLineMsgRecord paramDataLineMsgRecord, DataLineMsgSet paramDataLineMsgSet, Context paramContext, int paramInt, String paramString, boolean paramBoolean) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    if (2131299214 == paramView.getId())
    {
      awrm.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getCurrentAccountUin(), "dl_copy");
      ((ClipboardManager)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXListView.getContext().getSystemService("clipboard")).setText(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msg);
    }
    label445:
    label582:
    label587:
    do
    {
      Object localObject1;
      Object localObject2;
      int i;
      do
      {
        return;
        if (2131299423 == paramView.getId())
        {
          awrm.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getCurrentAccountUin(), "dl_delete");
          paramView = new av(this);
          localObject1 = new aw(this);
          babr.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131628272), this.jdField_a_of_type_AndroidContentContext.getString(2131628251), 2131625035, 2131628291, paramView, (DialogInterface.OnClickListener)localObject1).show();
          return;
        }
        if (2131301021 == paramView.getId())
        {
          awrm.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getCurrentAccountUin(), "dl_forward");
          if (this.jdField_a_of_type_Int == -1000)
          {
            paramView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("forward_text", new axkd(paramView.msg, 13, 32, 6000).toString());
            ((Intent)localObject1).putExtra("forward_type", -1);
            ((Intent)localObject1).putExtra("isFromShare", true);
            ((Intent)localObject1).putExtra("isFromDataLineAIO", true);
            aphp.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, (Intent)localObject1, 4);
            return;
          }
          if (bace.b(this.jdField_a_of_type_JavaLangString))
          {
            l = bace.a(this.jdField_a_of_type_JavaLangString);
            paramView = apck.a(this.jdField_a_of_type_JavaLangString);
            localObject1 = new ForwardFileInfo();
            ((ForwardFileInfo)localObject1).b(10000);
            ((ForwardFileInfo)localObject1).d(6);
            ((ForwardFileInfo)localObject1).d(paramView);
            ((ForwardFileInfo)localObject1).d(l);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.thumbPath))) {
              ((ForwardFileInfo)localObject1).f(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.thumbPath);
            }
            ((ForwardFileInfo)localObject1).a(this.jdField_a_of_type_JavaLangString);
            if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord != null) {
              ((ForwardFileInfo)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.entityID);
            }
            localObject2 = new Intent();
            if (this.jdField_a_of_type_Boolean)
            {
              ((Intent)localObject2).putExtra("forward_text", paramView);
              if (!this.jdField_a_of_type_Boolean) {
                break label582;
              }
              i = 1;
              ((Intent)localObject2).putExtra("forward_type", i);
              ((Intent)localObject2).putExtra("forward_filepath", this.jdField_a_of_type_JavaLangString);
              ((Intent)localObject2).putExtra("fileinfo", (Parcelable)localObject1);
              ((Intent)localObject2).putExtra("not_forward", true);
              ((Intent)localObject2).putExtra("isFromShare", true);
              ((Intent)localObject2).putExtra("isFromDataLineAIO", true);
              if (!this.jdField_a_of_type_Boolean) {
                break label587;
              }
              ((Intent)localObject2).putExtra("forward_thumb", this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.path);
            }
            for (;;)
            {
              aphp.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, (Intent)localObject2, 4);
              return;
              paramView = ajjy.a(2131640397) + paramView + ajjy.a(2131640395) + apdh.a(l) + "。";
              break;
              i = 0;
              break label445;
              ((Intent)localObject2).putExtra("k_favorites", false);
            }
          }
          apck.a(apck.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, 10009);
          return;
        }
        if (2131300328 == paramView.getId())
        {
          if (this.jdField_a_of_type_JavaLangString.isEmpty())
          {
            bfhl.a(null, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msg).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getActivity(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount());
            bfhz.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, 64, 1);
            return;
          }
          bfhl.b(this.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getActivity(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount());
          bfhz.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, 64, 3);
          return;
        }
        if (2131312887 != paramView.getId()) {
          break label1077;
        }
        awrm.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getCurrentAccountUin(), "dl_save2weiyun");
        long l = bace.a(this.jdField_a_of_type_JavaLangString);
        localObject1 = apck.a(this.jdField_a_of_type_JavaLangString);
        paramView = null;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
        if (((DataLineMsgRecord)localObject2).nWeiyunSessionId != 0L) {
          paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(((DataLineMsgRecord)localObject2).nWeiyunSessionId);
        }
        if ((!apck.a()) || (l <= aonj.a())) {
          break;
        }
      } while (!bbrm.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getActivity(), 5, new ax(this, (DataLineMsgRecord)localObject2, paramView, (String)localObject1)));
      apbx.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getActivity(), 2131627035, 2131627038, new ay(this, (DataLineMsgRecord)localObject2, paramView, (String)localObject1));
      return;
      if (paramView == null)
      {
        i = DataLineMsgRecord.getDevTypeBySeId(((DataLineMsgRecord)localObject2).sessionid);
        apcb.b(apck.d((String)localObject1) + this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131627189));
        ((DataLineMsgRecord)localObject2).nWeiyunSessionId = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(this.jdField_a_of_type_JavaLangString, null, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount(), 0, false).nSessionId;
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(i).c(((DataLineMsgRecord)localObject2).msgId);
        return;
      }
      apcb.b(apck.d((String)localObject1) + this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131627189));
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(((DataLineMsgRecord)localObject2).nWeiyunSessionId);
      return;
      if (2131296581 == paramView.getId())
      {
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet);
        return;
      }
    } while (2131311102 != paramView.getId());
    label1077:
    awqx.b(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    paramView = new TeamWorkFileImportInfo();
    paramView.c = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.path;
    paramView.b = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.filename;
    paramView.e = apck.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.filename);
    paramView.jdField_a_of_type_Int = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramView.jdField_d_of_type_Int = 1;
    paramView.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.filesize;
    axea.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     au
 * JD-Core Version:    0.7.0.1
 */