import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.theme.SkinnableBitmapDrawable;

public class aosb
  extends aosi
{
  protected aosb(QQAppInterface paramQQAppInterface, aosm paramaosm)
  {
    super(paramQQAppInterface, paramaosm);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return 526;
  }
  
  public aosm a(QQMessageFacade.Message paramMessage)
  {
    Object localObject = a() + ": ";
    this.a.b((String)localObject);
    this.a.d(c());
    a();
    a(paramMessage, this.a);
    paramMessage = bheg.e();
    localObject = BaseApplicationImpl.getContext().getResources().getDrawable(2130842738);
    if ((localObject instanceof BitmapDrawable)) {
      paramMessage = ((BitmapDrawable)localObject).getBitmap();
    }
    for (;;)
    {
      localObject = pqt.a(BaseApplicationImpl.getContext());
      this.a.a(paramMessage);
      this.a.c((String)localObject);
      return this.a;
      if ((localObject instanceof SkinnableBitmapDrawable)) {
        paramMessage = ((SkinnableBitmapDrawable)localObject).getBitmap();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosb
 * JD-Core Version:    0.7.0.1
 */