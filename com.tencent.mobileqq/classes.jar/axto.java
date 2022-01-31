import android.app.Activity;
import com.tencent.richmediabrowser.core.IMvpFactory;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.view.BaseView;

public class axto
  implements IMvpFactory
{
  public BrowserBaseModel createModel(int paramInt, BasePresenter paramBasePresenter)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return new axue();
    case 101: 
      new axuf();
    case 102: 
      return new axua();
    }
    return new axub();
  }
  
  public BasePresenter createPresenter(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return new axum();
    case 101: 
      return new axup();
    case 102: 
      return new axui();
    }
    return new axuk();
  }
  
  public BaseView createView(Activity paramActivity, int paramInt, BasePresenter paramBasePresenter)
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
          } while (!(paramBasePresenter instanceof axum));
          return new axvr(paramActivity, (axum)paramBasePresenter);
        } while (!(paramBasePresenter instanceof axup));
        return new axwf(paramActivity, (axup)paramBasePresenter);
      } while (!(paramBasePresenter instanceof axui));
      return new axvg(paramActivity, (axui)paramBasePresenter);
    } while (!(paramBasePresenter instanceof axuk));
    return new axvm(paramActivity, (axuk)paramBasePresenter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axto
 * JD-Core Version:    0.7.0.1
 */