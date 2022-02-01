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

public class aysd
  extends aysc
{
  public aysd(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(ayqn paramayqn)
  {
    return 1;
  }
  
  public View a(ViewGroup paramViewGroup, ayqn paramayqn)
  {
    paramayqn = (ayse)paramayqn;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561345, paramViewGroup, false);
    paramayqn.g = ((TextView)paramViewGroup.findViewById(2131380126));
    paramayqn.e = ((ImageView)paramViewGroup.findViewById(2131369184));
    paramayqn.f = ((ImageView)paramViewGroup.findViewById(2131369314));
    return paramViewGroup;
  }
  
  public ayqn a()
  {
    return new ayse(this);
  }
  
  public String a(ayqn paramayqn)
  {
    long l = ((aysn)((ayse)paramayqn).a).jdField_b_of_type_Long;
    if (l % 1000L > 500L) {}
    for (l = (int)l / 1000 + 1;; l = (int)l / 1000) {
      return String.valueOf(l);
    }
  }
  
  public void d(ayqn paramayqn)
  {
    aysn localaysn = (aysn)paramayqn.a;
    if ((localaysn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localaysn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      ayry.a(this.a, localaysn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 2);
      return;
    }
    super.d(paramayqn);
  }
  
  public void f(ayqn paramayqn)
  {
    ayse localayse = (ayse)paramayqn;
    aysn localaysn = (aysn)localayse.a;
    paramayqn = bhsy.a(this.a, localayse.a.a, localaysn.n);
    int j;
    String str;
    File localFile;
    boolean bool;
    if (TextUtils.isEmpty(paramayqn))
    {
      localayse.g.setVisibility(8);
      j = zps.a(this.a, 180.0F);
      str = (String)localayse.e.getTag(2131378440);
      if (localaysn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label544;
      }
      localFile = new File(localaysn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
      bool = localFile.exists();
    }
    for (;;)
    {
      Object localObject;
      int i;
      if (bool)
      {
        localObject = localaysn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        paramayqn = (ayqn)localObject;
        if (localaysn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth <= 0) {
          break label539;
        }
        paramayqn = (ayqn)localObject;
        if (localaysn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight <= 0) {
          break label539;
        }
        i = localaysn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight * j / localaysn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth;
        paramayqn = (ayqn)localObject;
      }
      for (;;)
      {
        label195:
        if (i * 3 > j * 4) {
          i = j * 4 / 3;
        }
        for (;;)
        {
          if (!TextUtils.equals(str, paramayqn))
          {
            localayse.e.setTag(2131378440, paramayqn);
            localObject = (FrameLayout.LayoutParams)localayse.e.getLayoutParams();
            if (localObject != null) {
              break label444;
            }
            localObject = new FrameLayout.LayoutParams(j, i);
            localayse.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          for (;;)
          {
            try
            {
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.a.getResources().getDrawable(2130845496);
              ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.a.getResources().getDrawable(2130845496);
              if (!bool) {
                continue;
              }
              paramayqn = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
              paramayqn.setTag(bhez.b(j, i, bhgr.a(this.a, 3.0F)));
              paramayqn.setDecodeHandler(bhez.e);
              localayse.e.setImageDrawable(paramayqn);
              return;
            }
            catch (Exception paramayqn)
            {
              label444:
              localayse.e.setImageDrawable(this.a.getResources().getDrawable(2130845496));
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("ShortVideoMomentItemBuilder", 1, paramayqn.toString());
              return;
            }
            localayse.g.setVisibility(0);
            if ((paramayqn instanceof SpannableString)) {
              localayse.g.setMovementMethod(LinkMovementMethod.getInstance());
            }
            localayse.g.setText(paramayqn);
            break;
            localObject = localaysn.jdField_a_of_type_JavaLangString;
            paramayqn = (ayqn)localObject;
            if (localaysn.jdField_a_of_type_Int <= 0) {
              break label539;
            }
            paramayqn = (ayqn)localObject;
            if (localaysn.jdField_b_of_type_Int <= 0) {
              break label539;
            }
            i = localaysn.jdField_b_of_type_Int * j / localaysn.jdField_a_of_type_Int;
            paramayqn = (ayqn)localObject;
            break label195;
            if ((((FrameLayout.LayoutParams)localObject).width != j) || (((FrameLayout.LayoutParams)localObject).height != i))
            {
              ((FrameLayout.LayoutParams)localObject).width = j;
              ((FrameLayout.LayoutParams)localObject).height = i;
              localayse.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
              continue;
              paramayqn = URLDrawable.getDrawable(paramayqn, (URLDrawable.URLDrawableOptions)localObject);
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
 * Qualified Name:     aysd
 * JD-Core Version:    0.7.0.1
 */