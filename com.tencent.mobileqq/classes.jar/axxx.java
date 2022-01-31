import android.app.Activity;
import com.tencent.richmediabrowser.core.IMvpFactory;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.view.BaseView;

public class axxx
  implements IMvpFactory
{
  public BrowserBaseModel createModel(int paramInt, BasePresenter paramBasePresenter)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return new axyn();
    case 101: 
      new axyo();
    case 102: 
      return new axyj();
    }
    return new axyk();
  }
  
  public BasePresenter createPresenter(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return new axyv();
    case 101: 
      return new axyy();
    case 102: 
      return new axyr();
    }
    return new axyt();
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
          } while (!(paramBasePresenter instanceof axyv));
          return new ayaa(paramActivity, (axyv)paramBasePresenter);
        } while (!(paramBasePresenter instanceof axyy));
        return new ayao(paramActivity, (axyy)paramBasePresenter);
      } while (!(paramBasePresenter instanceof axyr));
      return new axzp(paramActivity, (axyr)paramBasePresenter);
    } while (!(paramBasePresenter instanceof axyt));
    return new axzv(paramActivity, (axyt)paramBasePresenter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxx
 * JD-Core Version:    0.7.0.1
 */