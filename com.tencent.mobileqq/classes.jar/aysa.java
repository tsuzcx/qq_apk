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

public class aysa
  extends aysc
{
  public aysa(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(ayqn paramayqn)
  {
    return 2;
  }
  
  public View a(ViewGroup paramViewGroup, ayqn paramayqn)
  {
    paramayqn = (aysb)paramayqn;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561344, paramViewGroup, false);
    paramayqn.g = ((TextView)paramViewGroup.findViewById(2131380126));
    paramayqn.e = ((ImageView)paramViewGroup.findViewById(2131369308));
    return paramViewGroup;
  }
  
  public ayqn a()
  {
    return new aysb(this);
  }
  
  public void d(ayqn paramayqn)
  {
    aysl localaysl = (aysl)paramayqn.a;
    if ((localaysl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localaysl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      ayry.a(this.a, localaysl.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 4);
      return;
    }
    super.d(paramayqn);
  }
  
  public void f(ayqn paramayqn)
  {
    aysb localaysb = (aysb)paramayqn;
    Object localObject1 = (aysl)localaysb.a;
    paramayqn = ((aysl)localObject1).n;
    paramayqn = bhsy.a(this.a, localaysb.a.a, paramayqn);
    Object localObject2;
    if (TextUtils.isEmpty(paramayqn))
    {
      localaysb.g.setVisibility(8);
      localObject2 = (String)localaysb.e.getTag(2131378440);
      if (((aysl)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label475;
      }
      paramayqn = new File(((aysl)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
    }
    for (boolean bool = paramayqn.exists();; bool = false)
    {
      label132:
      int i;
      if (bool)
      {
        localObject1 = ((aysl)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
        {
          localaysb.e.setTag(2131378440, localObject1);
          localObject2 = (LinearLayout.LayoutParams)localaysb.e.getLayoutParams();
          i = zps.a(BaseApplicationImpl.getContext(), 180.0F);
          if (localObject2 != null) {
            break label368;
          }
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          localaysb.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130845496);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130845496);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "profileCard";
          if (!bool) {
            continue;
          }
          paramayqn = URLDrawable.getDrawable(paramayqn, (URLDrawable.URLDrawableOptions)localObject2);
          paramayqn.setTag(bhez.a(bhgr.a(localaysb.e.getContext(), 3.0F), 0, 0));
          paramayqn.setDecodeHandler(bhez.f);
          localaysb.e.setImageDrawable(paramayqn);
        }
        catch (Exception paramayqn)
        {
          label368:
          localaysb.e.setImageDrawable(this.a.getResources().getDrawable(2130845496));
          QLog.i("PicMomentItemBuilder", 1, paramayqn.toString());
          continue;
        }
        localaysb.e.setTag(localaysb);
        localaysb.e.setOnClickListener(this);
        return;
        localaysb.g.setVisibility(0);
        if ((paramayqn instanceof SpannableString)) {
          localaysb.g.setMovementMethod(LinkMovementMethod.getInstance());
        }
        localaysb.g.setText(paramayqn);
        break;
        localObject1 = ((aysl)localObject1).jdField_a_of_type_JavaLangString;
        break label132;
        if ((((LinearLayout.LayoutParams)localObject2).width <= i) && (((LinearLayout.LayoutParams)localObject2).height <= i)) {
          if (((LinearLayout.LayoutParams)localObject2).weight < ((LinearLayout.LayoutParams)localObject2).height)
          {
            ((LinearLayout.LayoutParams)localObject2).height = i;
            localaysb.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          else
          {
            ((LinearLayout.LayoutParams)localObject2).width = i;
            continue;
            paramayqn = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          }
        }
      }
      label475:
      paramayqn = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysa
 * JD-Core Version:    0.7.0.1
 */