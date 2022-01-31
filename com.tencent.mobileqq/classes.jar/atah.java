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

public class atah
  extends ataj
{
  public atah(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(asyu paramasyu)
  {
    return 2;
  }
  
  public View a(ViewGroup paramViewGroup, asyu paramasyu)
  {
    paramasyu = (atai)paramasyu;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131495317, paramViewGroup, false);
    paramasyu.g = ((TextView)paramViewGroup.findViewById(2131312545));
    paramasyu.e = ((ImageView)paramViewGroup.findViewById(2131303004));
    return paramViewGroup;
  }
  
  public asyu a()
  {
    return new atai(this);
  }
  
  public void d(asyu paramasyu)
  {
    atas localatas = (atas)paramasyu.a;
    if ((localatas.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localatas.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      ataf.a(this.a, localatas.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 4);
      return;
    }
    super.d(paramasyu);
  }
  
  public void f(asyu paramasyu)
  {
    atai localatai = (atai)paramasyu;
    Object localObject1 = (atas)localatai.a;
    paramasyu = ((atas)localObject1).n;
    paramasyu = baiw.a(this.a, localatai.a.a, paramasyu);
    Object localObject2;
    if (TextUtils.isEmpty(paramasyu))
    {
      localatai.g.setVisibility(8);
      localObject2 = (String)localatai.e.getTag(2131311070);
      if (((atas)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label475;
      }
      paramasyu = new File(((atas)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
    }
    for (boolean bool = paramasyu.exists();; bool = false)
    {
      label132:
      int i;
      if (bool)
      {
        localObject1 = ((atas)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
        {
          localatai.e.setTag(2131311070, localObject1);
          localObject2 = (LinearLayout.LayoutParams)localatai.e.getLayoutParams();
          i = vms.a(BaseApplicationImpl.getContext(), 180.0F);
          if (localObject2 != null) {
            break label368;
          }
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          localatai.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130844567);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130844567);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "profileCard";
          if (!bool) {
            continue;
          }
          paramasyu = URLDrawable.getDrawable(paramasyu, (URLDrawable.URLDrawableOptions)localObject2);
          paramasyu.setTag(azue.a(azvv.a(localatai.e.getContext(), 3.0F), 0, 0));
          paramasyu.setDecodeHandler(azue.f);
          localatai.e.setImageDrawable(paramasyu);
        }
        catch (Exception paramasyu)
        {
          label368:
          localatai.e.setImageDrawable(this.a.getResources().getDrawable(2130844567));
          QLog.i("PicMomentItemBuilder", 1, paramasyu.toString());
          continue;
        }
        localatai.e.setTag(localatai);
        localatai.e.setOnClickListener(this);
        return;
        localatai.g.setVisibility(0);
        if ((paramasyu instanceof SpannableString)) {
          localatai.g.setMovementMethod(LinkMovementMethod.getInstance());
        }
        localatai.g.setText(paramasyu);
        break;
        localObject1 = ((atas)localObject1).jdField_a_of_type_JavaLangString;
        break label132;
        if ((((LinearLayout.LayoutParams)localObject2).width <= i) && (((LinearLayout.LayoutParams)localObject2).height <= i)) {
          if (((LinearLayout.LayoutParams)localObject2).weight < ((LinearLayout.LayoutParams)localObject2).height)
          {
            ((LinearLayout.LayoutParams)localObject2).height = i;
            localatai.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          else
          {
            ((LinearLayout.LayoutParams)localObject2).width = i;
            continue;
            paramasyu = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          }
        }
      }
      label475:
      paramasyu = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atah
 * JD-Core Version:    0.7.0.1
 */