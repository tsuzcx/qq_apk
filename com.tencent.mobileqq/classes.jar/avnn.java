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

public class avnn
  extends avnp
{
  public avnn(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(avma paramavma)
  {
    return 2;
  }
  
  public View a(ViewGroup paramViewGroup, avma paramavma)
  {
    paramavma = (avno)paramavma;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561077, paramViewGroup, false);
    paramavma.g = ((TextView)paramViewGroup.findViewById(2131378975));
    paramavma.e = ((ImageView)paramViewGroup.findViewById(2131368841));
    return paramViewGroup;
  }
  
  public avma a()
  {
    return new avno(this);
  }
  
  public void d(avma paramavma)
  {
    avny localavny = (avny)paramavma.a;
    if ((localavny.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localavny.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      avnl.a(this.a, localavny.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 4);
      return;
    }
    super.d(paramavma);
  }
  
  public void f(avma paramavma)
  {
    avno localavno = (avno)paramavma;
    Object localObject1 = (avny)localavno.a;
    paramavma = ((avny)localObject1).n;
    paramavma = bdjl.a(this.a, localavno.a.a, paramavma);
    Object localObject2;
    if (TextUtils.isEmpty(paramavma))
    {
      localavno.g.setVisibility(8);
      localObject2 = (String)localavno.e.getTag(2131377396);
      if (((avny)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label475;
      }
      paramavma = new File(((avny)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
    }
    for (boolean bool = paramavma.exists();; bool = false)
    {
      label132:
      int i;
      if (bool)
      {
        localObject1 = ((avny)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
        {
          localavno.e.setTag(2131377396, localObject1);
          localObject2 = (LinearLayout.LayoutParams)localavno.e.getLayoutParams();
          i = xod.a(BaseApplicationImpl.getContext(), 180.0F);
          if (localObject2 != null) {
            break label368;
          }
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          localavno.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130845013);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130845013);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "profileCard";
          if (!bool) {
            continue;
          }
          paramavma = URLDrawable.getDrawable(paramavma, (URLDrawable.URLDrawableOptions)localObject2);
          paramavma.setTag(bcuq.a(bcwh.a(localavno.e.getContext(), 3.0F), 0, 0));
          paramavma.setDecodeHandler(bcuq.f);
          localavno.e.setImageDrawable(paramavma);
        }
        catch (Exception paramavma)
        {
          label368:
          localavno.e.setImageDrawable(this.a.getResources().getDrawable(2130845013));
          QLog.i("PicMomentItemBuilder", 1, paramavma.toString());
          continue;
        }
        localavno.e.setTag(localavno);
        localavno.e.setOnClickListener(this);
        return;
        localavno.g.setVisibility(0);
        if ((paramavma instanceof SpannableString)) {
          localavno.g.setMovementMethod(LinkMovementMethod.getInstance());
        }
        localavno.g.setText(paramavma);
        break;
        localObject1 = ((avny)localObject1).jdField_a_of_type_JavaLangString;
        break label132;
        if ((((LinearLayout.LayoutParams)localObject2).width <= i) && (((LinearLayout.LayoutParams)localObject2).height <= i)) {
          if (((LinearLayout.LayoutParams)localObject2).weight < ((LinearLayout.LayoutParams)localObject2).height)
          {
            ((LinearLayout.LayoutParams)localObject2).height = i;
            localavno.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          else
          {
            ((LinearLayout.LayoutParams)localObject2).width = i;
            continue;
            paramavma = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          }
        }
      }
      label475:
      paramavma = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avnn
 * JD-Core Version:    0.7.0.1
 */