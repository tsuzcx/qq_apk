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

public class avrw
  extends avry
{
  public avrw(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(avqj paramavqj)
  {
    return 2;
  }
  
  public View a(ViewGroup paramViewGroup, avqj paramavqj)
  {
    paramavqj = (avrx)paramavqj;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561095, paramViewGroup, false);
    paramavqj.g = ((TextView)paramViewGroup.findViewById(2131379033));
    paramavqj.e = ((ImageView)paramViewGroup.findViewById(2131368856));
    return paramViewGroup;
  }
  
  public avqj a()
  {
    return new avrx(this);
  }
  
  public void d(avqj paramavqj)
  {
    avsh localavsh = (avsh)paramavqj.a;
    if ((localavsh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localavsh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      avru.a(this.a, localavsh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 4);
      return;
    }
    super.d(paramavqj);
  }
  
  public void f(avqj paramavqj)
  {
    avrx localavrx = (avrx)paramavqj;
    Object localObject1 = (avsh)localavrx.a;
    paramavqj = ((avsh)localObject1).n;
    paramavqj = bdnu.a(this.a, localavrx.a.a, paramavqj);
    Object localObject2;
    if (TextUtils.isEmpty(paramavqj))
    {
      localavrx.g.setVisibility(8);
      localObject2 = (String)localavrx.e.getTag(2131377450);
      if (((avsh)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label475;
      }
      paramavqj = new File(((avsh)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
    }
    for (boolean bool = paramavqj.exists();; bool = false)
    {
      label132:
      int i;
      if (bool)
      {
        localObject1 = ((avsh)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
        {
          localavrx.e.setTag(2131377450, localObject1);
          localObject2 = (LinearLayout.LayoutParams)localavrx.e.getLayoutParams();
          i = xsm.a(BaseApplicationImpl.getContext(), 180.0F);
          if (localObject2 != null) {
            break label368;
          }
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          localavrx.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130845085);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130845085);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "profileCard";
          if (!bool) {
            continue;
          }
          paramavqj = URLDrawable.getDrawable(paramavqj, (URLDrawable.URLDrawableOptions)localObject2);
          paramavqj.setTag(bcyz.a(bdaq.a(localavrx.e.getContext(), 3.0F), 0, 0));
          paramavqj.setDecodeHandler(bcyz.f);
          localavrx.e.setImageDrawable(paramavqj);
        }
        catch (Exception paramavqj)
        {
          label368:
          localavrx.e.setImageDrawable(this.a.getResources().getDrawable(2130845085));
          QLog.i("PicMomentItemBuilder", 1, paramavqj.toString());
          continue;
        }
        localavrx.e.setTag(localavrx);
        localavrx.e.setOnClickListener(this);
        return;
        localavrx.g.setVisibility(0);
        if ((paramavqj instanceof SpannableString)) {
          localavrx.g.setMovementMethod(LinkMovementMethod.getInstance());
        }
        localavrx.g.setText(paramavqj);
        break;
        localObject1 = ((avsh)localObject1).jdField_a_of_type_JavaLangString;
        break label132;
        if ((((LinearLayout.LayoutParams)localObject2).width <= i) && (((LinearLayout.LayoutParams)localObject2).height <= i)) {
          if (((LinearLayout.LayoutParams)localObject2).weight < ((LinearLayout.LayoutParams)localObject2).height)
          {
            ((LinearLayout.LayoutParams)localObject2).height = i;
            localavrx.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          else
          {
            ((LinearLayout.LayoutParams)localObject2).width = i;
            continue;
            paramavqj = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          }
        }
      }
      label475:
      paramavqj = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avrw
 * JD-Core Version:    0.7.0.1
 */