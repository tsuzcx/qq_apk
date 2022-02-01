import android.app.Activity;
import com.tencent.richmediabrowser.core.IMvpFactory;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.view.BrowserBaseView;

public class bbor
  implements IMvpFactory
{
  public BrowserBaseModel createModel(int paramInt, BasePresenter paramBasePresenter)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return new bbpn();
    case 101: 
      return new bbpo();
    case 102: 
      return new bbpj();
    }
    return new bbpk();
  }
  
  public BasePresenter createPresenter(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return new bbpv();
    case 101: 
      return new bbpy();
    case 102: 
      return new bbpr();
    }
    return new bbpt();
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
          } while (!(paramBasePresenter instanceof bbpv));
          return new bbrb(paramActivity, (bbpv)paramBasePresenter);
        } while (!(paramBasePresenter instanceof bbpy));
        return new bbrp(paramActivity, (bbpy)paramBasePresenter);
      } while (!(paramBasePresenter instanceof bbpr));
      return new bbqq(paramActivity, (bbpr)paramBasePresenter);
    } while (!(paramBasePresenter instanceof bbpt));
    return new bbqw(paramActivity, (bbpt)paramBasePresenter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbor
 * JD-Core Version:    0.7.0.1
 */