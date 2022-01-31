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

public class atwn
  extends atwp
{
  public atwn(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(atva paramatva)
  {
    return 2;
  }
  
  public View a(ViewGroup paramViewGroup, atva paramatva)
  {
    paramatva = (atwo)paramatva;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131560894, paramViewGroup, false);
    paramatva.g = ((TextView)paramViewGroup.findViewById(2131378373));
    paramatva.e = ((ImageView)paramViewGroup.findViewById(2131368637));
    return paramViewGroup;
  }
  
  public atva a()
  {
    return new atwo(this);
  }
  
  public void d(atva paramatva)
  {
    atwy localatwy = (atwy)paramatva.a;
    if ((localatwy.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localatwy.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      atwl.a(this.a, localatwy.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 4);
      return;
    }
    super.d(paramatva);
  }
  
  public void f(atva paramatva)
  {
    atwo localatwo = (atwo)paramatva;
    Object localObject1 = (atwy)localatwo.a;
    paramatva = ((atwy)localObject1).n;
    paramatva = bbkr.a(this.a, localatwo.a.a, paramatva);
    Object localObject2;
    if (TextUtils.isEmpty(paramatva))
    {
      localatwo.g.setVisibility(8);
      localObject2 = (String)localatwo.e.getTag(2131376882);
      if (((atwy)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label475;
      }
      paramatva = new File(((atwy)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
    }
    for (boolean bool = paramatva.exists();; bool = false)
    {
      label132:
      int i;
      if (bool)
      {
        localObject1 = ((atwy)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
        {
          localatwo.e.setTag(2131376882, localObject1);
          localObject2 = (LinearLayout.LayoutParams)localatwo.e.getLayoutParams();
          i = vzl.a(BaseApplicationImpl.getContext(), 180.0F);
          if (localObject2 != null) {
            break label368;
          }
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          localatwo.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130844649);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130844649);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "profileCard";
          if (!bool) {
            continue;
          }
          paramatva = URLDrawable.getDrawable(paramatva, (URLDrawable.URLDrawableOptions)localObject2);
          paramatva.setTag(bavw.a(baxn.a(localatwo.e.getContext(), 3.0F), 0, 0));
          paramatva.setDecodeHandler(bavw.f);
          localatwo.e.setImageDrawable(paramatva);
        }
        catch (Exception paramatva)
        {
          label368:
          localatwo.e.setImageDrawable(this.a.getResources().getDrawable(2130844649));
          QLog.i("PicMomentItemBuilder", 1, paramatva.toString());
          continue;
        }
        localatwo.e.setTag(localatwo);
        localatwo.e.setOnClickListener(this);
        return;
        localatwo.g.setVisibility(0);
        if ((paramatva instanceof SpannableString)) {
          localatwo.g.setMovementMethod(LinkMovementMethod.getInstance());
        }
        localatwo.g.setText(paramatva);
        break;
        localObject1 = ((atwy)localObject1).jdField_a_of_type_JavaLangString;
        break label132;
        if ((((LinearLayout.LayoutParams)localObject2).width <= i) && (((LinearLayout.LayoutParams)localObject2).height <= i)) {
          if (((LinearLayout.LayoutParams)localObject2).weight < ((LinearLayout.LayoutParams)localObject2).height)
          {
            ((LinearLayout.LayoutParams)localObject2).height = i;
            localatwo.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          else
          {
            ((LinearLayout.LayoutParams)localObject2).width = i;
            continue;
            paramatva = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          }
        }
      }
      label475:
      paramatva = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwn
 * JD-Core Version:    0.7.0.1
 */