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
    int i;
    if (2131364859 == paramView.getId())
    {
      azrh.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getCurrentAccountUin(), "dl_copy");
      ((ClipboardManager)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXListView.getContext().getSystemService("clipboard")).setText(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msg);
      i = LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity);
      azqs.b(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, "dc00898", "", "", "0X800AD63", "0X800AD63", 1, 0, "" + i, "", "", "");
    }
    label626:
    do
    {
      return;
      Object localObject;
      int j;
      if (2131365077 == paramView.getId())
      {
        azrh.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getCurrentAccountUin(), "dl_delete");
        paramView = new av(this);
        localObject = new aw(this);
        bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131694032), this.jdField_a_of_type_AndroidContentContext.getString(2131694011), 2131690648, 2131694051, paramView, (DialogInterface.OnClickListener)localObject).show();
        i = LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, this.jdField_a_of_type_Int);
        j = LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity);
        azqs.b(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, "dc00898", "", "", "0X800AD5D", "0X800AD5D", i, 0, "" + j, "", "", "");
        return;
      }
      if (2131366760 == paramView.getId())
      {
        azrh.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getCurrentAccountUin(), "dl_forward");
        if (this.jdField_a_of_type_Int == -1000)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
          localObject = new Intent();
          ((Intent)localObject).putExtra("forward_text", new bamp(paramView.msg, 13, 32, 6000).toString());
          ((Intent)localObject).putExtra("forward_type", -1);
          ((Intent)localObject).putExtra("isFromShare", true);
          ((Intent)localObject).putExtra("isFromDataLineAIO", true);
          aryv.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, (Intent)localObject, 4);
        }
        for (;;)
        {
          i = LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, this.jdField_a_of_type_Int);
          j = LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity);
          azqs.b(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, "dc00898", "", "", "0X800AD5B", "0X800AD5B", i, 0, "" + j, "", "", "");
          return;
          if (bdhb.b(this.jdField_a_of_type_JavaLangString))
          {
            long l = bdhb.a(this.jdField_a_of_type_JavaLangString);
            paramView = arrr.a(this.jdField_a_of_type_JavaLangString);
            localObject = new ForwardFileInfo();
            ((ForwardFileInfo)localObject).b(10000);
            ((ForwardFileInfo)localObject).d(6);
            ((ForwardFileInfo)localObject).d(paramView);
            ((ForwardFileInfo)localObject).d(l);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.thumbPath))) {
              ((ForwardFileInfo)localObject).f(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.thumbPath);
            }
            ((ForwardFileInfo)localObject).a(this.jdField_a_of_type_JavaLangString);
            if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord != null) {
              ((ForwardFileInfo)localObject).b(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.entityID);
            }
            Intent localIntent = new Intent();
            if (this.jdField_a_of_type_Boolean)
            {
              localIntent.putExtra("forward_text", paramView);
              if (!this.jdField_a_of_type_Boolean) {
                break label789;
              }
              i = 1;
              localIntent.putExtra("forward_type", i);
              localIntent.putExtra("forward_filepath", this.jdField_a_of_type_JavaLangString);
              localIntent.putExtra("fileinfo", (Parcelable)localObject);
              localIntent.putExtra("not_forward", true);
              localIntent.putExtra("isFromShare", true);
              localIntent.putExtra("isFromDataLineAIO", true);
              if (!this.jdField_a_of_type_Boolean) {
                break label794;
              }
              localIntent.putExtra("forward_thumb", this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.path);
            }
            for (;;)
            {
              aryv.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, localIntent, 4);
              break;
              paramView = alud.a(2131706577) + paramView + alud.a(2131706575) + arso.a(l) + "。";
              break label626;
              i = 0;
              break label644;
              localIntent.putExtra("k_favorites", false);
            }
          }
          arrr.a(arrr.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, 10009);
        }
      }
      if (2131366017 == paramView.getId())
      {
        if (this.jdField_a_of_type_JavaLangString.isEmpty())
        {
          biva.a(null, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msg).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getActivity(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount());
          bivo.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, 64, 1);
        }
        for (;;)
        {
          i = LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, this.jdField_a_of_type_Int);
          j = LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity);
          azqs.b(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, "dc00898", "", "", "0X800AD5C", "0X800AD5C", i, 0, "" + j, "", "", "");
          return;
          if (this.jdField_a_of_type_Int == -2000)
          {
            biva.b(this.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getActivity(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount());
            bivo.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, 64, 3);
          }
          else if ((this.jdField_a_of_type_Int == -2005) || (this.jdField_a_of_type_Int == -2009))
          {
            new biva(3).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_JavaLangString);
          }
        }
      }
      if (2131379392 == paramView.getId())
      {
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
        return;
      }
      if (2131362126 == paramView.getId())
      {
        LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, this.jdField_a_of_type_Int);
        return;
      }
    } while (2131377486 != paramView.getId());
    label644:
    label789:
    label794:
    azqs.b(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    paramView = new TeamWorkFileImportInfo();
    paramView.c = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.path;
    paramView.b = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.filename;
    paramView.e = arrr.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.filename);
    paramView.jdField_a_of_type_Int = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramView.jdField_d_of_type_Int = 1;
    paramView.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.filesize;
    bagk.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     au
 * JD-Core Version:    0.7.0.1
 */