import android.text.TextUtils;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class baon
  extends anwt
{
  public baon(QCallDetailActivity paramQCallDetailActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((((ArrayList)paramObject).indexOf(QCallDetailActivity.a(this.a)) != -1) && (paramBoolean) && (QCallDetailActivity.a(this.a) == 3000)) {
      this.a.a(QCallDetailActivity.a(this.a));
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((QCallDetailActivity.a(this.a) != null) && (QCallDetailActivity.a(this.a).equals(paramString)) && (QCallDetailActivity.a(this.a) == 3000)) {
      this.a.a(paramString);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCallDetailActivity", 2, " === onUpdateDiscussionFaceIcon isSuccess | " + paramBoolean1 + ", disUin | " + paramString + ",isComplete | " + paramBoolean2);
    }
    if ((paramBoolean1) && (paramBoolean2) && (QCallDetailActivity.a(this.a) != null) && (QCallDetailActivity.a(this.a) == 3000))
    {
      String str = paramString;
      if (GroupIconHelper.a(paramString)) {
        str = GroupIconHelper.b(paramString);
      }
      if (QCallDetailActivity.a(this.a).equals(str))
      {
        this.a.a(QCallDetailActivity.a(this.a));
        if (QLog.isColorLevel()) {
          QLog.i("QCallDetailActivity", 2, "==== onUpdateDiscussionFaceIcon updateUin ===");
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(QCallDetailActivity.a(this.a))) && (QCallDetailActivity.a(this.a).equals(paramString)) && (!this.a.isFinishing())) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baon
 * JD-Core Version:    0.7.0.1
 */