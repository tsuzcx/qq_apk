import android.app.Activity;
import com.tencent.richmediabrowser.core.IMvpFactory;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.view.BrowserBaseView;

public class bavy
  implements IMvpFactory
{
  public BrowserBaseModel createModel(int paramInt, BasePresenter paramBasePresenter)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return new bawu();
    case 101: 
      return new bawv();
    case 102: 
      return new bawq();
    }
    return new bawr();
  }
  
  public BasePresenter createPresenter(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return new baxc();
    case 101: 
      return new baxf();
    case 102: 
      return new bawy();
    }
    return new baxa();
  }
  
  public BrowserBaseView createView(Activity paramActivity, int paramInt, BasePresenter paramBasePresenter)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return null;
          } while (!(paramBasePresenter instanceof baxc));
          return new bayi(paramActivity, (baxc)paramBasePresenter);
        } while (!(paramBasePresenter instanceof baxf));
        return new bayw(paramActivity, (baxf)paramBasePresenter);
      } while (!(paramBasePresenter instanceof bawy));
      return new baxx(paramActivity, (bawy)paramBasePresenter);
    } while (!(paramBasePresenter instanceof baxa));
    return new bayd(paramActivity, (baxa)paramBasePresenter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavy
 * JD-Core Version:    0.7.0.1
 */