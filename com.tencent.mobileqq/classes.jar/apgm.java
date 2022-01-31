import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog.2;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class apgm
  extends Dialog
  implements Handler.Callback
{
  public static int a;
  private static String jdField_a_of_type_JavaLangString = "DBFix";
  public static int b;
  public static int c = 1;
  public static int d = 2;
  public static int e = 3;
  public static int f = 1;
  public static int g = 2;
  public static int h = 3;
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private apgo jdField_a_of_type_Apgo;
  private bhsl jdField_a_of_type_Bhsl = new bhsl(Looper.getMainLooper(), this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private File jdField_a_of_type_JavaIoFile;
  private Runnable jdField_a_of_type_JavaLangRunnable = new DBFixLoadingDialog.2(this);
  private long jdField_b_of_type_Long;
  private File jdField_b_of_type_JavaIoFile;
  private String jdField_b_of_type_JavaLangString;
  private int i = jdField_b_of_type_Int;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  apgm(QQAppInterface paramQQAppInterface, Context paramContext, apgo paramapgo)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Apgo = paramapgo;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == f) {
      if (this.i == c)
      {
        k = (int)((float)(System.currentTimeMillis() - this.jdField_b_of_type_Long) / (10.0F * this.jdField_a_of_type_Float));
        j = k;
        if (k > 90) {
          j = (k - 90) / 10 + 90;
        }
        j = Math.min(j, 99);
        paramMessage = String.format(alud.a(2131703263), new Object[] { Integer.valueOf(j) });
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
        this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(f, 500L);
      }
    }
    while (paramMessage.what != g)
    {
      do
      {
        int k;
        int j;
        return false;
        if (this.i == d)
        {
          ((DBFixManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(205)).b(true);
          if (!this.jdField_b_of_type_JavaIoFile.renameTo(this.jdField_a_of_type_JavaIoFile))
          {
            QLog.d(jdField_a_of_type_JavaLangString, 1, "db fix succ but copy fail");
            boolean bool = bdhb.a(this.jdField_b_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile);
            bdhb.d(this.jdField_b_of_type_JavaIoFile.getPath());
            if (!bool)
            {
              QLog.d(jdField_a_of_type_JavaLangString, 1, "db fix succ but copy fail final");
              paramMessage = new HashMap();
              azri.a(BaseApplication.getContext()).a(null, DBFixManager.m, true, -1L, 0L, paramMessage, null, false);
            }
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131703264));
          this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(g, 100L);
          return false;
        }
      } while (this.i != e);
      dismiss();
      this.jdField_a_of_type_Apgo.a(this.i);
      return false;
    }
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing())) {
      dismiss();
    }
    this.jdField_a_of_type_Apgo.a(this.i);
    return false;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2131559251);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365023));
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaIoFile = this.jdField_a_of_type_AndroidContentContext.getDatabasePath(this.jdField_b_of_type_JavaLangString + ".db");
    this.jdField_b_of_type_JavaIoFile = this.jdField_a_of_type_AndroidContentContext.getDatabasePath(this.jdField_b_of_type_JavaLangString + "_dump.db");
    this.jdField_a_of_type_Long = this.jdField_a_of_type_JavaIoFile.length();
    this.jdField_a_of_type_Float = ((float)this.jdField_a_of_type_Long / 1216348.1F);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(DBFixManager.jdField_b_of_type_JavaLangString, 0);
    jdField_a_of_type_Int = localSharedPreferences.getInt(paramBundle + DBFixManager.c, 2);
    if (localSharedPreferences.getInt(paramBundle + DBFixManager.e, 0) > 2) {
      if (jdField_a_of_type_Int != 2) {
        break label396;
      }
    }
    label396:
    for (int j = 1;; j = 2)
    {
      jdField_a_of_type_Int = j;
      localSharedPreferences.edit().putInt(paramBundle + DBFixManager.c, jdField_a_of_type_Int).commit();
      String str = localSharedPreferences.getString(paramBundle + DBFixManager.k, "");
      localSharedPreferences.edit().putString(paramBundle + DBFixManager.k, str + "_" + jdField_a_of_type_Int).commit();
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 10, null, true);
      super.setOnKeyListener(new apgn(this));
      return;
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_Bhsl.sendEmptyMessage(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apgm
 * JD-Core Version:    0.7.0.1
 */