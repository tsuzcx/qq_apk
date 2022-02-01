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

public class axzg
  extends axzi
{
  public axzg(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(axxt paramaxxt)
  {
    return 2;
  }
  
  public View a(ViewGroup paramViewGroup, axxt paramaxxt)
  {
    paramaxxt = (axzh)paramaxxt;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561306, paramViewGroup, false);
    paramaxxt.g = ((TextView)paramViewGroup.findViewById(2131379942));
    paramaxxt.e = ((ImageView)paramViewGroup.findViewById(2131369217));
    return paramViewGroup;
  }
  
  public axxt a()
  {
    return new axzh(this);
  }
  
  public void d(axxt paramaxxt)
  {
    axzr localaxzr = (axzr)paramaxxt.a;
    if ((localaxzr.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localaxzr.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      axze.a(this.a, localaxzr.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 4);
      return;
    }
    super.d(paramaxxt);
  }
  
  public void f(axxt paramaxxt)
  {
    axzh localaxzh = (axzh)paramaxxt;
    Object localObject1 = (axzr)localaxzh.a;
    paramaxxt = ((axzr)localObject1).n;
    paramaxxt = bgsw.a(this.a, localaxzh.a.a, paramaxxt);
    Object localObject2;
    if (TextUtils.isEmpty(paramaxxt))
    {
      localaxzh.g.setVisibility(8);
      localObject2 = (String)localaxzh.e.getTag(2131378283);
      if (((axzr)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label475;
      }
      paramaxxt = new File(((axzr)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
    }
    for (boolean bool = paramaxxt.exists();; bool = false)
    {
      label132:
      int i;
      if (bool)
      {
        localObject1 = ((axzr)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
        {
          localaxzh.e.setTag(2131378283, localObject1);
          localObject2 = (LinearLayout.LayoutParams)localaxzh.e.getLayoutParams();
          i = zlx.a(BaseApplicationImpl.getContext(), 180.0F);
          if (localObject2 != null) {
            break label368;
          }
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          localaxzh.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130845481);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130845481);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "profileCard";
          if (!bool) {
            continue;
          }
          paramaxxt = URLDrawable.getDrawable(paramaxxt, (URLDrawable.URLDrawableOptions)localObject2);
          paramaxxt.setTag(bgey.a(bggq.a(localaxzh.e.getContext(), 3.0F), 0, 0));
          paramaxxt.setDecodeHandler(bgey.f);
          localaxzh.e.setImageDrawable(paramaxxt);
        }
        catch (Exception paramaxxt)
        {
          label368:
          localaxzh.e.setImageDrawable(this.a.getResources().getDrawable(2130845481));
          QLog.i("PicMomentItemBuilder", 1, paramaxxt.toString());
          continue;
        }
        localaxzh.e.setTag(localaxzh);
        localaxzh.e.setOnClickListener(this);
        return;
        localaxzh.g.setVisibility(0);
        if ((paramaxxt instanceof SpannableString)) {
          localaxzh.g.setMovementMethod(LinkMovementMethod.getInstance());
        }
        localaxzh.g.setText(paramaxxt);
        break;
        localObject1 = ((axzr)localObject1).jdField_a_of_type_JavaLangString;
        break label132;
        if ((((LinearLayout.LayoutParams)localObject2).width <= i) && (((LinearLayout.LayoutParams)localObject2).height <= i)) {
          if (((LinearLayout.LayoutParams)localObject2).weight < ((LinearLayout.LayoutParams)localObject2).height)
          {
            ((LinearLayout.LayoutParams)localObject2).height = i;
            localaxzh.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          else
          {
            ((LinearLayout.LayoutParams)localObject2).width = i;
            continue;
            paramaxxt = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          }
        }
      }
      label475:
      paramaxxt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzg
 * JD-Core Version:    0.7.0.1
 */