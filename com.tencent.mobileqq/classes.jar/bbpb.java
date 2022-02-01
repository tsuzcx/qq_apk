import android.app.Activity;
import com.tencent.richmediabrowser.core.IMvpFactory;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.view.BrowserBaseView;

public class bbpb
  implements IMvpFactory
{
  public BrowserBaseModel createModel(int paramInt, BasePresenter paramBasePresenter)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return new bbpx();
    case 101: 
      return new bbpy();
    case 102: 
      return new bbpt();
    }
    return new bbpu();
  }
  
  public BasePresenter createPresenter(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return new bbqf();
    case 101: 
      return new bbqi();
    case 102: 
      return new bbqb();
    }
    return new bbqd();
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
          } while (!(paramBasePresenter instanceof bbqf));
          return new bbrl(paramActivity, (bbqf)paramBasePresenter);
        } while (!(paramBasePresenter instanceof bbqi));
        return new bbrz(paramActivity, (bbqi)paramBasePresenter);
      } while (!(paramBasePresenter instanceof bbqb));
      return new bbra(paramActivity, (bbqb)paramBasePresenter);
    } while (!(paramBasePresenter instanceof bbqd));
    return new bbrg(paramActivity, (bbqd)paramBasePresenter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpb
 * JD-Core Version:    0.7.0.1
 */