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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class axzj
  extends axzi
{
  public axzj(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(axxt paramaxxt)
  {
    return 1;
  }
  
  public View a(ViewGroup paramViewGroup, axxt paramaxxt)
  {
    paramaxxt = (axzk)paramaxxt;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561307, paramViewGroup, false);
    paramaxxt.g = ((TextView)paramViewGroup.findViewById(2131379942));
    paramaxxt.e = ((ImageView)paramViewGroup.findViewById(2131369094));
    paramaxxt.f = ((ImageView)paramViewGroup.findViewById(2131369223));
    return paramViewGroup;
  }
  
  public axxt a()
  {
    return new axzk(this);
  }
  
  public String a(axxt paramaxxt)
  {
    long l = ((axzt)((axzk)paramaxxt).a).jdField_b_of_type_Long;
    if (l % 1000L > 500L) {}
    for (l = (int)l / 1000 + 1;; l = (int)l / 1000) {
      return String.valueOf(l);
    }
  }
  
  public void d(axxt paramaxxt)
  {
    axzt localaxzt = (axzt)paramaxxt.a;
    if ((localaxzt.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localaxzt.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      axze.a(this.a, localaxzt.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 2);
      return;
    }
    super.d(paramaxxt);
  }
  
  public void f(axxt paramaxxt)
  {
    axzk localaxzk = (axzk)paramaxxt;
    axzt localaxzt = (axzt)localaxzk.a;
    paramaxxt = bgsw.a(this.a, localaxzk.a.a, localaxzt.n);
    int j;
    String str;
    File localFile;
    boolean bool;
    if (TextUtils.isEmpty(paramaxxt))
    {
      localaxzk.g.setVisibility(8);
      j = zlx.a(this.a, 180.0F);
      str = (String)localaxzk.e.getTag(2131378283);
      if (localaxzt.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label544;
      }
      localFile = new File(localaxzt.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
      bool = localFile.exists();
    }
    for (;;)
    {
      Object localObject;
      int i;
      if (bool)
      {
        localObject = localaxzt.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        paramaxxt = (axxt)localObject;
        if (localaxzt.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth <= 0) {
          break label539;
        }
        paramaxxt = (axxt)localObject;
        if (localaxzt.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight <= 0) {
          break label539;
        }
        i = localaxzt.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight * j / localaxzt.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth;
        paramaxxt = (axxt)localObject;
      }
      for (;;)
      {
        label195:
        if (i * 3 > j * 4) {
          i = j * 4 / 3;
        }
        for (;;)
        {
          if (!TextUtils.equals(str, paramaxxt))
          {
            localaxzk.e.setTag(2131378283, paramaxxt);
            localObject = (FrameLayout.LayoutParams)localaxzk.e.getLayoutParams();
            if (localObject != null) {
              break label444;
            }
            localObject = new FrameLayout.LayoutParams(j, i);
            localaxzk.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          for (;;)
          {
            try
            {
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.a.getResources().getDrawable(2130845481);
              ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.a.getResources().getDrawable(2130845481);
              if (!bool) {
                continue;
              }
              paramaxxt = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
              paramaxxt.setTag(bgey.b(j, i, bggq.a(this.a, 3.0F)));
              paramaxxt.setDecodeHandler(bgey.e);
              localaxzk.e.setImageDrawable(paramaxxt);
              return;
            }
            catch (Exception paramaxxt)
            {
              label444:
              localaxzk.e.setImageDrawable(this.a.getResources().getDrawable(2130845481));
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("ShortVideoMomentItemBuilder", 1, paramaxxt.toString());
              return;
            }
            localaxzk.g.setVisibility(0);
            if ((paramaxxt instanceof SpannableString)) {
              localaxzk.g.setMovementMethod(LinkMovementMethod.getInstance());
            }
            localaxzk.g.setText(paramaxxt);
            break;
            localObject = localaxzt.jdField_a_of_type_JavaLangString;
            paramaxxt = (axxt)localObject;
            if (localaxzt.jdField_a_of_type_Int <= 0) {
              break label539;
            }
            paramaxxt = (axxt)localObject;
            if (localaxzt.jdField_b_of_type_Int <= 0) {
              break label539;
            }
            i = localaxzt.jdField_b_of_type_Int * j / localaxzt.jdField_a_of_type_Int;
            paramaxxt = (axxt)localObject;
            break label195;
            if ((((FrameLayout.LayoutParams)localObject).width != j) || (((FrameLayout.LayoutParams)localObject).height != i))
            {
              ((FrameLayout.LayoutParams)localObject).width = j;
              ((FrameLayout.LayoutParams)localObject).height = i;
              localaxzk.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
              continue;
              paramaxxt = URLDrawable.getDrawable(paramaxxt, (URLDrawable.URLDrawableOptions)localObject);
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
 * Qualified Name:     axzj
 * JD-Core Version:    0.7.0.1
 */