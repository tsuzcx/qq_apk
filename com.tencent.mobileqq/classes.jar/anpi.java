import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.theme.SkinnableBitmapDrawable;

public class anpi
  extends anpp
{
  protected anpi(QQAppInterface paramQQAppInterface, anpt paramanpt)
  {
    super(paramQQAppInterface, paramanpt);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return 526;
  }
  
  public anpt a(QQMessageFacade.Message paramMessage)
  {
    Object localObject = a() + ": ";
    this.a.b((String)localObject);
    this.a.d(c());
    a();
    a(paramMessage, this.a);
    paramMessage = bfvo.e();
    localObject = BaseApplicationImpl.getContext().getResources().getDrawable(2130842709);
    if ((localObject instanceof BitmapDrawable)) {
      paramMessage = ((BitmapDrawable)localObject).getBitmap();
    }
    for (;;)
    {
      localObject = pay.d(BaseApplicationImpl.getContext());
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
 * Qualified Name:     anpi
 * JD-Core Version:    0.7.0.1
 */