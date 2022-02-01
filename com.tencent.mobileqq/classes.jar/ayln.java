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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ayln
  extends aylp
{
  public ayln(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(ayka paramayka)
  {
    return 2;
  }
  
  public View a(ViewGroup paramViewGroup, ayka paramayka)
  {
    paramayka = (aylo)paramayka;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561280, paramViewGroup, false);
    paramayka.g = ((TextView)paramViewGroup.findViewById(2131380198));
    paramayka.e = ((ImageView)paramViewGroup.findViewById(2131369488));
    return paramViewGroup;
  }
  
  public ayka a()
  {
    return new aylo(this);
  }
  
  public void d(ayka paramayka)
  {
    ayly localayly = (ayly)paramayka.a;
    if ((localayly.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localayly.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      ayll.a(this.a, localayly.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 4);
      return;
    }
    super.d(paramayka);
  }
  
  public void f(ayka paramayka)
  {
    aylo localaylo = (aylo)paramayka;
    Object localObject1 = (ayly)localaylo.a;
    paramayka = ((ayly)localObject1).n;
    paramayka = bhif.a(this.a, localaylo.a.a, paramayka);
    Object localObject2;
    if (TextUtils.isEmpty(paramayka))
    {
      localaylo.g.setVisibility(8);
      localObject2 = (String)localaylo.e.getTag(2131378495);
      if (((ayly)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label475;
      }
      paramayka = new File(((ayly)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
    }
    for (boolean bool = paramayka.exists();; bool = false)
    {
      label132:
      int i;
      if (bool)
      {
        localObject1 = ((ayly)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
        {
          localaylo.e.setTag(2131378495, localObject1);
          localObject2 = (LinearLayout.LayoutParams)localaylo.e.getLayoutParams();
          i = UIUtils.dip2px(BaseApplicationImpl.getContext(), 180.0F);
          if (localObject2 != null) {
            break label368;
          }
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          localaylo.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130845460);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130845460);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "profileCard";
          if (!bool) {
            continue;
          }
          paramayka = URLDrawable.getDrawable(paramayka, (URLDrawable.URLDrawableOptions)localObject2);
          paramayka.setTag(bgxc.a(DisplayUtil.dip2px(localaylo.e.getContext(), 3.0F), 0, 0));
          paramayka.setDecodeHandler(bgxc.f);
          localaylo.e.setImageDrawable(paramayka);
        }
        catch (Exception paramayka)
        {
          label368:
          localaylo.e.setImageDrawable(this.a.getResources().getDrawable(2130845460));
          QLog.i("PicMomentItemBuilder", 1, paramayka.toString());
          continue;
        }
        localaylo.e.setTag(localaylo);
        localaylo.e.setOnClickListener(this);
        return;
        localaylo.g.setVisibility(0);
        if ((paramayka instanceof SpannableString)) {
          localaylo.g.setMovementMethod(LinkMovementMethod.getInstance());
        }
        localaylo.g.setText(paramayka);
        break;
        localObject1 = ((ayly)localObject1).jdField_a_of_type_JavaLangString;
        break label132;
        if ((((LinearLayout.LayoutParams)localObject2).width <= i) && (((LinearLayout.LayoutParams)localObject2).height <= i)) {
          if (((LinearLayout.LayoutParams)localObject2).weight < ((LinearLayout.LayoutParams)localObject2).height)
          {
            ((LinearLayout.LayoutParams)localObject2).height = i;
            localaylo.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          else
          {
            ((LinearLayout.LayoutParams)localObject2).width = i;
            continue;
            paramayka = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          }
        }
      }
      label475:
      paramayka = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayln
 * JD-Core Version:    0.7.0.1
 */