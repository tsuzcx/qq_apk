import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import com.tencent.richmediabrowser.view.recyclerview.DragView;

public class bbqp
  extends MainBrowserScene
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  public TextureView a;
  private View jdField_a_of_type_AndroidViewView;
  private bbpq jdField_a_of_type_Bbpq;
  
  public bbqp(Activity paramActivity, bbpq parambbpq)
  {
    super(paramActivity, parambbpq);
    this.mActivity = paramActivity;
    this.jdField_a_of_type_Bbpq = parambbpq;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AIOBrowserScene.1(this), 1000L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TextureView localTextureView;
    if (this.jdField_a_of_type_AndroidViewTextureView != null)
    {
      localTextureView = this.jdField_a_of_type_AndroidViewTextureView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextureView.setVisibility(i);
      return;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidViewTextureView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidViewTextureView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean back()
  {
    a(false);
    return super.back();
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public void initView()
  {
    super.initView();
    this.mDragView.setOriginRect(bbox.a().a());
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.mContext).inflate(2131558588, null);
    if (bbov.a()) {
      this.jdField_a_of_type_AndroidViewTextureView = ((TextureView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365259));
    }
    getContentView().addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 19002)
    {
      if (paramInt2 == -1) {
        this.mContext.setResult(-1, paramIntent);
      }
      this.mContext.finish();
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (paramInt1 != 19000) {
                  break;
                }
              } while (paramInt2 != -1);
              return;
              if (paramInt1 != 19005) {
                break;
              }
            } while (paramInt2 != -1);
            paramIntent = getCurrentView();
          } while (!(paramIntent instanceof bbqn));
          ((bbqn)paramIntent).b();
          return;
        } while (paramInt1 == 103);
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if ((paramInt2 != -1) || (paramInt1 != 0)) {
          break;
        }
        bbqi.a(this.mContext, paramIntent.getExtras());
      } while (bbox.a().a() != 9501);
      this.mContext.finish();
      return;
    } while ((paramInt2 != -1) || (paramInt1 != 10001));
    QQToast.a(this.mContext, 2131718211, 0).a();
  }
  
  public void onContentMove(float paramFloat)
  {
    super.onContentMove(paramFloat);
    this.jdField_a_of_type_Bbpq.a(false);
    if ((getCurrentView() instanceof bbqn)) {
      ((bbqn)getCurrentView()).b(false);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onGestureFinish()
  {
    Object localObject = this.jdField_a_of_type_Bbpq.a.getSelectedItem();
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null)) {
      if (((RichMediaBrowserInfo)localObject).baseData.getType() == 100) {
        localObject = "0X8009AB2";
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        bdll.b(null, "dc00898", "", "", (String)localObject, (String)localObject, bbox.a().c(), 0, "", "", "", "");
      }
      this.jdField_a_of_type_Bbpq.i();
      super.onGestureFinish();
      return;
      if (((RichMediaBrowserInfo)localObject).baseData.getType() == 101) {
        localObject = "0X8009AB3";
      } else {
        localObject = null;
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Bbpq.b(this.jdField_a_of_type_Bbpq.getCurrentPosition())) {
      this.jdField_a_of_type_Bbpq.a(true);
    }
  }
  
  public void onResetPosition()
  {
    if (bbox.a().c() == 4) {}
    do
    {
      return;
      super.onResetPosition();
      this.jdField_a_of_type_Bbpq.d();
    } while (!(getCurrentView() instanceof bbqn));
    ((bbqn)getCurrentView()).b(true);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Bbpq.b(this.jdField_a_of_type_Bbpq.getCurrentPosition())) {
      this.jdField_a_of_type_Bbpq.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqp
 * JD-Core Version:    0.7.0.1
 */