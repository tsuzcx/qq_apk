import android.app.Activity;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameLifeCycle.1;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class andj
{
  public static String a;
  public int a;
  private anck jdField_a_of_type_Anck;
  private ancy jdField_a_of_type_Ancy;
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "cmgame_process.CmGameLifeCycle";
  }
  
  public andj(int paramInt)
  {
    this.b = paramInt;
  }
  
  private Activity a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  private QQAppInterface a()
  {
    AppInterface localAppInterface = anbd.a();
    if ((localAppInterface instanceof QQAppInterface)) {
      return (QQAppInterface)localAppInterface;
    }
    return null;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public andl a()
  {
    if (this.jdField_a_of_type_Anck == null) {
      return null;
    }
    return this.jdField_a_of_type_Anck.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Anck != null) {
      this.jdField_a_of_type_Anck.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[handleActLifeCycle], gameId:" + paramInt1 + ",status:" + paramInt2);
    Object localObject1 = a();
    if (localObject1 == null) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "app is null.");
    }
    do
    {
      do
      {
        Object localObject2;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if ((2 == paramInt2) && (this.jdField_a_of_type_Anck != null))
                {
                  localObject2 = this.jdField_a_of_type_Anck.a();
                  if (localObject2 != null) {
                    ((andl)localObject2).d();
                  }
                }
                if (4 != paramInt2) {
                  break;
                }
              } while (this.jdField_a_of_type_Anck == null);
              localObject1 = this.jdField_a_of_type_Anck.a();
            } while (localObject1 == null);
            ((andl)localObject1).e();
            return;
            if (1 != paramInt2) {
              break;
            }
            localObject2 = a();
            if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (localObject2 == null))
            {
              QLog.w(jdField_a_of_type_JavaLangString, 1, "null error.");
              return;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId != paramInt1)
            {
              QLog.w(jdField_a_of_type_JavaLangString, 1, "not the same game.");
              return;
            }
            if (this.jdField_a_of_type_Anck != null) {
              CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_Anck);
            }
            if (this.jdField_a_of_type_Ancy != null) {
              CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_Ancy);
            }
            this.jdField_a_of_type_Ancy = new ancy((Activity)localObject2, (QQAppInterface)localObject1, this.b);
            CmGameCmdChannel.a((QQAppInterface)localObject1).a(this.jdField_a_of_type_Ancy);
            if ((!anbd.a(this.b)) && (!anbd.b(this.b)))
            {
              andl localandl = new andl((Activity)localObject2, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
              this.jdField_a_of_type_Anck = new anck((Activity)localObject2, localandl, this.b);
              CmGameCmdChannel.a((QQAppInterface)localObject1).a(this.jdField_a_of_type_Anck);
              localandl.a((Activity)localObject2);
              localandl.f();
              localandl.g();
              return;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null);
          QLog.e(jdField_a_of_type_JavaLangString, 1, "land or game box game data not exit");
          ApolloGameUtil.a((QQAppInterface)localObject1, 0L);
          return;
        } while (5 != paramInt2);
        if (this.jdField_a_of_type_Anck != null)
        {
          localObject2 = this.jdField_a_of_type_Anck.a();
          if (localObject2 != null) {
            ((andl)localObject2).j();
          }
          this.jdField_a_of_type_Anck.a();
          CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_Anck);
          this.jdField_a_of_type_Anck = null;
        }
        if (this.jdField_a_of_type_Ancy != null)
        {
          this.jdField_a_of_type_Ancy.a();
          CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_Ancy);
          this.jdField_a_of_type_Ancy = null;
        }
      } while ((anbd.a(this.b)) || (anbd.b(this.b)) || (a() == null));
      localObject1 = (amsx)a().getManager(153);
    } while ((localObject1 == null) || (!((amsx)localObject1).j()) || (anbd.a(null)) || (((amsx)localObject1).k) || (((amsx)localObject1).h()) || (((amsx)localObject1).i()) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
    ((amsx)localObject1).h = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src != 319) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src != 318)) {
      anbd.a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "plus status first play goBackToPlus");
  }
  
  public void a(Activity paramActivity, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (paramStartCheckParam != null) && (paramStartCheckParam.game != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game = paramStartCheckParam.game;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Anck != null)
    {
      andl localandl = this.jdField_a_of_type_Anck.a();
      if ((localandl != null) && (localandl.a)) {
        ThreadManagerV2.getUIHandlerV2().post(new CmGameLifeCycle.1(this, localandl));
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Anck != null)
    {
      andl localandl = this.jdField_a_of_type_Anck.a();
      if ((localandl != null) && (localandl.a)) {
        localandl.h();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andj
 * JD-Core Version:    0.7.0.1
 */