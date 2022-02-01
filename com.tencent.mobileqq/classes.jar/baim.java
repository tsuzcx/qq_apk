import android.app.Activity;
import com.tencent.richmediabrowser.core.IMvpFactory;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.view.BrowserBaseView;

public class baim
  implements IMvpFactory
{
  public BrowserBaseModel createModel(int paramInt, BasePresenter paramBasePresenter)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return new baji();
    case 101: 
      return new bajj();
    case 102: 
      return new baje();
    }
    return new bajf();
  }
  
  public BasePresenter createPresenter(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return new bajq();
    case 101: 
      return new bajt();
    case 102: 
      return new bajm();
    }
    return new bajo();
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
          } while (!(paramBasePresenter instanceof bajq));
          return new bakw(paramActivity, (bajq)paramBasePresenter);
        } while (!(paramBasePresenter instanceof bajt));
        return new balk(paramActivity, (bajt)paramBasePresenter);
      } while (!(paramBasePresenter instanceof bajm));
      return new bakl(paramActivity, (bajm)paramBasePresenter);
    } while (!(paramBasePresenter instanceof bajo));
    return new bakr(paramActivity, (bajo)paramBasePresenter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baim
 * JD-Core Version:    0.7.0.1
 */