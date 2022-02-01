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

public class axfi
  extends axfk
{
  public axfi(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(axdv paramaxdv)
  {
    return 2;
  }
  
  public View a(ViewGroup paramViewGroup, axdv paramaxdv)
  {
    paramaxdv = (axfj)paramaxdv;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561219, paramViewGroup, false);
    paramaxdv.g = ((TextView)paramViewGroup.findViewById(2131379865));
    paramaxdv.e = ((ImageView)paramViewGroup.findViewById(2131369321));
    return paramViewGroup;
  }
  
  public axdv a()
  {
    return new axfj(this);
  }
  
  public void d(axdv paramaxdv)
  {
    axft localaxft = (axft)paramaxdv.a;
    if ((localaxft.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localaxft.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      axfg.a(this.a, localaxft.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 4);
      return;
    }
    super.d(paramaxdv);
  }
  
  public void f(axdv paramaxdv)
  {
    axfj localaxfj = (axfj)paramaxdv;
    Object localObject1 = (axft)localaxfj.a;
    paramaxdv = ((axft)localObject1).n;
    paramaxdv = bfzn.a(this.a, localaxfj.a.a, paramaxdv);
    Object localObject2;
    if (TextUtils.isEmpty(paramaxdv))
    {
      localaxfj.g.setVisibility(8);
      localObject2 = (String)localaxfj.e.getTag(2131378207);
      if (((axft)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label475;
      }
      paramaxdv = new File(((axft)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
    }
    for (boolean bool = paramaxdv.exists();; bool = false)
    {
      label132:
      int i;
      if (bool)
      {
        localObject1 = ((axft)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
        {
          localaxfj.e.setTag(2131378207, localObject1);
          localObject2 = (LinearLayout.LayoutParams)localaxfj.e.getLayoutParams();
          i = UIUtils.dip2px(BaseApplicationImpl.getContext(), 180.0F);
          if (localObject2 != null) {
            break label368;
          }
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          localaxfj.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130845375);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130845375);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "profileCard";
          if (!bool) {
            continue;
          }
          paramaxdv = URLDrawable.getDrawable(paramaxdv, (URLDrawable.URLDrawableOptions)localObject2);
          paramaxdv.setTag(bfol.a(DisplayUtil.dip2px(localaxfj.e.getContext(), 3.0F), 0, 0));
          paramaxdv.setDecodeHandler(bfol.f);
          localaxfj.e.setImageDrawable(paramaxdv);
        }
        catch (Exception paramaxdv)
        {
          label368:
          localaxfj.e.setImageDrawable(this.a.getResources().getDrawable(2130845375));
          QLog.i("PicMomentItemBuilder", 1, paramaxdv.toString());
          continue;
        }
        localaxfj.e.setTag(localaxfj);
        localaxfj.e.setOnClickListener(this);
        return;
        localaxfj.g.setVisibility(0);
        if ((paramaxdv instanceof SpannableString)) {
          localaxfj.g.setMovementMethod(LinkMovementMethod.getInstance());
        }
        localaxfj.g.setText(paramaxdv);
        break;
        localObject1 = ((axft)localObject1).jdField_a_of_type_JavaLangString;
        break label132;
        if ((((LinearLayout.LayoutParams)localObject2).width <= i) && (((LinearLayout.LayoutParams)localObject2).height <= i)) {
          if (((LinearLayout.LayoutParams)localObject2).weight < ((LinearLayout.LayoutParams)localObject2).height)
          {
            ((LinearLayout.LayoutParams)localObject2).height = i;
            localaxfj.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          else
          {
            ((LinearLayout.LayoutParams)localObject2).width = i;
            continue;
            paramaxdv = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          }
        }
      }
      label475:
      paramaxdv = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axfi
 * JD-Core Version:    0.7.0.1
 */