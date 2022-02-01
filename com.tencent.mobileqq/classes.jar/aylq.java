import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aylq
  extends aylp
{
  public aylq(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(ayka paramayka)
  {
    return 1;
  }
  
  public View a(ViewGroup paramViewGroup, ayka paramayka)
  {
    paramayka = (aylr)paramayka;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561281, paramViewGroup, false);
    paramayka.g = ((TextView)paramViewGroup.findViewById(2131380198));
    paramayka.e = ((ImageView)paramViewGroup.findViewById(2131369370));
    paramayka.f = ((ImageView)paramViewGroup.findViewById(2131369491));
    return paramViewGroup;
  }
  
  public ayka a()
  {
    return new aylr(this);
  }
  
  public String a(ayka paramayka)
  {
    long l = ((ayma)((aylr)paramayka).a).jdField_b_of_type_Long;
    if (l % 1000L > 500L) {}
    for (l = (int)l / 1000 + 1;; l = (int)l / 1000) {
      return String.valueOf(l);
    }
  }
  
  public void d(ayka paramayka)
  {
    ayma localayma = (ayma)paramayka.a;
    if ((localayma.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localayma.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      ayll.a(this.a, localayma.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 2);
      return;
    }
    super.d(paramayka);
  }
  
  public void f(ayka paramayka)
  {
    aylr localaylr = (aylr)paramayka;
    ayma localayma = (ayma)localaylr.a;
    paramayka = bhif.a(this.a, localaylr.a.a, localayma.n);
    int j;
    String str;
    File localFile;
    boolean bool;
    if (TextUtils.isEmpty(paramayka))
    {
      localaylr.g.setVisibility(8);
      j = UIUtils.dip2px(this.a, 180.0F);
      str = (String)localaylr.e.getTag(2131378495);
      if (localayma.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label544;
      }
      localFile = new File(localayma.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
      bool = localFile.exists();
    }
    for (;;)
    {
      Object localObject;
      int i;
      if (bool)
      {
        localObject = localayma.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        paramayka = (ayka)localObject;
        if (localayma.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth <= 0) {
          break label539;
        }
        paramayka = (ayka)localObject;
        if (localayma.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight <= 0) {
          break label539;
        }
        i = localayma.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight * j / localayma.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth;
        paramayka = (ayka)localObject;
      }
      for (;;)
      {
        label195:
        if (i * 3 > j * 4) {
          i = j * 4 / 3;
        }
        for (;;)
        {
          if (!TextUtils.equals(str, paramayka))
          {
            localaylr.e.setTag(2131378495, paramayka);
            localObject = (FrameLayout.LayoutParams)localaylr.e.getLayoutParams();
            if (localObject != null) {
              break label444;
            }
            localObject = new FrameLayout.LayoutParams(j, i);
            localaylr.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          for (;;)
          {
            try
            {
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.a.getResources().getDrawable(2130845460);
              ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.a.getResources().getDrawable(2130845460);
              if (!bool) {
                continue;
              }
              paramayka = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
              paramayka.setTag(bgxc.b(j, i, DisplayUtil.dip2px(this.a, 3.0F)));
              paramayka.setDecodeHandler(bgxc.e);
              localaylr.e.setImageDrawable(paramayka);
              return;
            }
            catch (Exception paramayka)
            {
              label444:
              localaylr.e.setImageDrawable(this.a.getResources().getDrawable(2130845460));
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("ShortVideoMomentItemBuilder", 1, paramayka.toString());
              return;
            }
            localaylr.g.setVisibility(0);
            if ((paramayka instanceof SpannableString)) {
              localaylr.g.setMovementMethod(LinkMovementMethod.getInstance());
            }
            localaylr.g.setText(paramayka);
            break;
            localObject = localayma.jdField_a_of_type_JavaLangString;
            paramayka = (ayka)localObject;
            if (localayma.jdField_a_of_type_Int <= 0) {
              break label539;
            }
            paramayka = (ayka)localObject;
            if (localayma.jdField_b_of_type_Int <= 0) {
              break label539;
            }
            i = localayma.jdField_b_of_type_Int * j / localayma.jdField_a_of_type_Int;
            paramayka = (ayka)localObject;
            break label195;
            if ((((FrameLayout.LayoutParams)localObject).width != j) || (((FrameLayout.LayoutParams)localObject).height != i))
            {
              ((FrameLayout.LayoutParams)localObject).width = j;
              ((FrameLayout.LayoutParams)localObject).height = i;
              localaylr.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
              continue;
              paramayka = URLDrawable.getDrawable(paramayka, (URLDrawable.URLDrawableOptions)localObject);
            }
          }
        }
        label539:
        i = j;
      }
      label544:
      bool = false;
      localFile = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylq
 * JD-Core Version:    0.7.0.1
 */