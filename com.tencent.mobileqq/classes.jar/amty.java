import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amty
  extends QQCustomDialog
  implements Handler.Callback, View.OnClickListener
{
  public int a;
  public long a;
  private ahzp jdField_a_of_type_Ahzp;
  public Context a;
  private Handler jdField_a_of_type_AndroidOsHandler = new bkys(this);
  public View.OnClickListener a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  public CornerImageView a;
  public String a;
  public int b;
  public ImageView b;
  public TextView b;
  public CornerImageView b;
  private int c;
  public ImageView c;
  public TextView c;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  
  public amty(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, 2131755202);
    getWindow().requestFeature(1);
    setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(paramQQAppInterface);
    a();
  }
  
  public String a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return ApolloUtil.a(this.jdField_a_of_type_JavaLangString, "robotOpenId");
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGamePlayAgainDialog", 0, "[initView] init dialog view.");
    }
    View localView = getLayoutInflater().inflate(2131558932, null);
    this.g = ((TextView)localView.findViewById(2131379833));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369527));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131376817));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380076));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379751));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380120));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)localView.findViewById(2131369295));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(mvk.a(this.jdField_a_of_type_AndroidContentContext, 76.0F));
    this.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)localView.findViewById(2131369297));
    this.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(mvk.a(this.jdField_a_of_type_AndroidContentContext, 76.0F));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369345));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369346));
    this.d = ((TextView)localView.findViewById(2131380004));
    this.e = ((TextView)localView.findViewById(2131380132));
    this.f = ((TextView)localView.findViewById(2131379871));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.g.setTextColor(amub.a(Color.parseColor("#ffffff"), Color.parseColor("#80ffec00")));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(amub.a(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(amub.a(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(amub.a(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
    this.f.setBackgroundDrawable(new asbh(Color.parseColor("#4d000000"), mvk.a(this.jdField_a_of_type_AndroidContentContext, 20.0F), (int)mvk.a(this.jdField_a_of_type_AndroidContentContext, 250.0F), (int)mvk.a(this.jdField_a_of_type_AndroidContentContext, 29.0F)));
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(amub.a(this.jdField_a_of_type_AndroidContentContext, (int)((float)DeviceInfoUtil.getPortraitWidth() - mvk.a(this.jdField_a_of_type_AndroidContentContext, 54.0F)), (int)mvk.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), "#000000"));
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(amub.a(this.jdField_a_of_type_AndroidContentContext, (int)((float)DeviceInfoUtil.getPortraitWidth() - mvk.a(this.jdField_a_of_type_AndroidContentContext, 64.0F)) / 2, (int)mvk.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), "#000000"));
    this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundDrawable(amub.a(this.jdField_a_of_type_AndroidContentContext, (int)((float)DeviceInfoUtil.getPortraitWidth() - mvk.a(this.jdField_a_of_type_AndroidContentContext, 64.0F)) / 2, (int)mvk.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), "#3e3f40"));
    setContentView(localView);
    getWindow().setLayout(-1, -1);
    getWindow().getDecorView().setBackgroundColor(Color.parseColor("#9f000000"));
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.f.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131701607));
      this.g.setVisibility(0);
      return;
    }
    if (paramInt == 1)
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).arg1 = 30;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.f.setVisibility(0);
      this.f.setText(anvx.a(2131701608));
      this.g.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_Ahzp != null)
    {
      this.f.setVisibility(0);
      String str = this.jdField_a_of_type_Ahzp.jdField_a_of_type_JavaLangString;
      localObject = str;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Ahzp.jdField_a_of_type_JavaLangString))
      {
        TextPaint localTextPaint = new TextPaint();
        paramInt = this.jdField_a_of_type_Ahzp.jdField_a_of_type_JavaLangString.length();
        float f1 = localTextPaint.measureText(this.jdField_a_of_type_Ahzp.jdField_a_of_type_JavaLangString);
        localObject = str;
        while (f1 > 60.0F)
        {
          localObject = this.jdField_a_of_type_Ahzp.jdField_a_of_type_JavaLangString;
          paramInt -= 1;
          localObject = ((String)localObject).substring(0, paramInt);
          f1 = localTextPaint.measureText((String)localObject);
        }
        if (paramInt < this.jdField_a_of_type_Ahzp.jdField_a_of_type_JavaLangString.length()) {
          localObject = this.jdField_a_of_type_Ahzp.jdField_a_of_type_JavaLangString.substring(0, paramInt - 1) + "...";
        }
      }
      this.f.setText((String)localObject + anvx.a(2131701606));
    }
    this.g.setVisibility(4);
    Object localObject = Message.obtain();
    ((Message)localObject).what = 2;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 30000L);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(ahzp paramahzp, int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Ahzp = paramahzp;
    this.d.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
    this.e.setText(paramahzp.jdField_a_of_type_JavaLangString);
    paramString = URLDrawable.URLDrawableOptions.obtain();
    paramString.mRequestWidth = ((int)mvk.a(getContext(), 173.0F));
    paramString.mRequestHeight = ((int)mvk.a(getContext(), 97.0F));
    if (paramInt2 == 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramString = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_aio_fail.png", paramString);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
    }
    for (;;)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0, (byte)3);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramString));
      this.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageURL(paramahzp.d);
      a(0);
      return;
      if (paramInt2 == 1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        paramString = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_aio_success.png", paramString);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        paramString = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_aio_draw.png", paramString);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    super.dismiss();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        if (paramMessage.arg1 >= 0) {
          break;
        }
      } while (this.jdField_a_of_type_AndroidViewView$OnClickListener == null);
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.g);
      return true;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage.arg1 + "s");
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      int i = paramMessage.arg1 - 1;
      paramMessage.arg1 = i;
      localMessage.arg1 = i;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
      return true;
    } while (this.jdField_a_of_type_AndroidViewView$OnClickListener == null);
    this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.g);
    return true;
  }
  
  public void onClick(View paramView)
  {
    QLog.e("CmGamePlayAgainDialog", 1, "[onclick] " + paramView.getClass().toString() + ",id:" + paramView.getId());
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.g);
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amty
 * JD-Core Version:    0.7.0.1
 */