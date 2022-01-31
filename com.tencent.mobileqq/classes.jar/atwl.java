import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class atwl
  extends atwn
{
  public atwl(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(atuy paramatuy)
  {
    return 2;
  }
  
  public View a(ViewGroup paramViewGroup, atuy paramatuy)
  {
    paramatuy = (atwm)paramatuy;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131560895, paramViewGroup, false);
    paramatuy.g = ((TextView)paramViewGroup.findViewById(2131378370));
    paramatuy.e = ((ImageView)paramViewGroup.findViewById(2131368638));
    return paramViewGroup;
  }
  
  public atuy a()
  {
    return new atwm(this);
  }
  
  public void d(atuy paramatuy)
  {
    atww localatww = (atww)paramatuy.a;
    if ((localatww.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localatww.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      atwj.a(this.a, localatww.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 4);
      return;
    }
    super.d(paramatuy);
  }
  
  public void f(atuy paramatuy)
  {
    atwm localatwm = (atwm)paramatuy;
    Object localObject1 = (atww)localatwm.a;
    paramatuy = ((atww)localObject1).n;
    paramatuy = bbkd.a(this.a, localatwm.a.a, paramatuy);
    Object localObject2;
    if (TextUtils.isEmpty(paramatuy))
    {
      localatwm.g.setVisibility(8);
      localObject2 = (String)localatwm.e.getTag(2131376880);
      if (((atww)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label475;
      }
      paramatuy = new File(((atww)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
    }
    for (boolean bool = paramatuy.exists();; bool = false)
    {
      label132:
      int i;
      if (bool)
      {
        localObject1 = ((atww)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
        {
          localatwm.e.setTag(2131376880, localObject1);
          localObject2 = (LinearLayout.LayoutParams)localatwm.e.getLayoutParams();
          i = vzo.a(BaseApplicationImpl.getContext(), 180.0F);
          if (localObject2 != null) {
            break label368;
          }
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          localatwm.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130844648);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130844648);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "profileCard";
          if (!bool) {
            continue;
          }
          paramatuy = URLDrawable.getDrawable(paramatuy, (URLDrawable.URLDrawableOptions)localObject2);
          paramatuy.setTag(bavi.a(bawz.a(localatwm.e.getContext(), 3.0F), 0, 0));
          paramatuy.setDecodeHandler(bavi.f);
          localatwm.e.setImageDrawable(paramatuy);
        }
        catch (Exception paramatuy)
        {
          label368:
          localatwm.e.setImageDrawable(this.a.getResources().getDrawable(2130844648));
          QLog.i("PicMomentItemBuilder", 1, paramatuy.toString());
          continue;
        }
        localatwm.e.setTag(localatwm);
        localatwm.e.setOnClickListener(this);
        return;
        localatwm.g.setVisibility(0);
        if ((paramatuy instanceof SpannableString)) {
          localatwm.g.setMovementMethod(LinkMovementMethod.getInstance());
        }
        localatwm.g.setText(paramatuy);
        break;
        localObject1 = ((atww)localObject1).jdField_a_of_type_JavaLangString;
        break label132;
        if ((((LinearLayout.LayoutParams)localObject2).width <= i) && (((LinearLayout.LayoutParams)localObject2).height <= i)) {
          if (((LinearLayout.LayoutParams)localObject2).weight < ((LinearLayout.LayoutParams)localObject2).height)
          {
            ((LinearLayout.LayoutParams)localObject2).height = i;
            localatwm.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          else
          {
            ((LinearLayout.LayoutParams)localObject2).width = i;
            continue;
            paramatuy = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          }
        }
      }
      label475:
      paramatuy = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwl
 * JD-Core Version:    0.7.0.1
 */