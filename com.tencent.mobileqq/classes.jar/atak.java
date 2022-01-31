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

public class atak
  extends ataj
{
  public atak(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(asyu paramasyu)
  {
    return 1;
  }
  
  public View a(ViewGroup paramViewGroup, asyu paramasyu)
  {
    paramasyu = (atal)paramasyu;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131495318, paramViewGroup, false);
    paramasyu.g = ((TextView)paramViewGroup.findViewById(2131312545));
    paramasyu.e = ((ImageView)paramViewGroup.findViewById(2131302919));
    paramasyu.f = ((ImageView)paramViewGroup.findViewById(2131303006));
    return paramViewGroup;
  }
  
  public asyu a()
  {
    return new atal(this);
  }
  
  public String a(asyu paramasyu)
  {
    long l = ((atau)((atal)paramasyu).a).jdField_b_of_type_Long;
    if (l % 1000L > 500L) {}
    for (l = (int)l / 1000 + 1;; l = (int)l / 1000) {
      return String.valueOf(l);
    }
  }
  
  public void d(asyu paramasyu)
  {
    atau localatau = (atau)paramasyu.a;
    if ((localatau.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localatau.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      ataf.a(this.a, localatau.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 2);
      return;
    }
    super.d(paramasyu);
  }
  
  public void f(asyu paramasyu)
  {
    atal localatal = (atal)paramasyu;
    atau localatau = (atau)localatal.a;
    paramasyu = baiw.a(this.a, localatal.a.a, localatau.n);
    int j;
    String str;
    File localFile;
    boolean bool;
    if (TextUtils.isEmpty(paramasyu))
    {
      localatal.g.setVisibility(8);
      j = vms.a(this.a, 180.0F);
      str = (String)localatal.e.getTag(2131311070);
      if (localatau.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label544;
      }
      localFile = new File(localatau.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
      bool = localFile.exists();
    }
    for (;;)
    {
      Object localObject;
      int i;
      if (bool)
      {
        localObject = localatau.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        paramasyu = (asyu)localObject;
        if (localatau.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth <= 0) {
          break label539;
        }
        paramasyu = (asyu)localObject;
        if (localatau.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight <= 0) {
          break label539;
        }
        i = localatau.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight * j / localatau.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth;
        paramasyu = (asyu)localObject;
      }
      for (;;)
      {
        label195:
        if (i * 3 > j * 4) {
          i = j * 4 / 3;
        }
        for (;;)
        {
          if (!TextUtils.equals(str, paramasyu))
          {
            localatal.e.setTag(2131311070, paramasyu);
            localObject = (FrameLayout.LayoutParams)localatal.e.getLayoutParams();
            if (localObject != null) {
              break label444;
            }
            localObject = new FrameLayout.LayoutParams(j, i);
            localatal.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          for (;;)
          {
            try
            {
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.a.getResources().getDrawable(2130844567);
              ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.a.getResources().getDrawable(2130844567);
              if (!bool) {
                continue;
              }
              paramasyu = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
              paramasyu.setTag(azue.b(j, i, azvv.a(this.a, 3.0F)));
              paramasyu.setDecodeHandler(azue.e);
              localatal.e.setImageDrawable(paramasyu);
              return;
            }
            catch (Exception paramasyu)
            {
              label444:
              localatal.e.setImageDrawable(this.a.getResources().getDrawable(2130844567));
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("ShortVideoMomentItemBuilder", 1, paramasyu.toString());
              return;
            }
            localatal.g.setVisibility(0);
            if ((paramasyu instanceof SpannableString)) {
              localatal.g.setMovementMethod(LinkMovementMethod.getInstance());
            }
            localatal.g.setText(paramasyu);
            break;
            localObject = localatau.jdField_a_of_type_JavaLangString;
            paramasyu = (asyu)localObject;
            if (localatau.jdField_a_of_type_Int <= 0) {
              break label539;
            }
            paramasyu = (asyu)localObject;
            if (localatau.jdField_b_of_type_Int <= 0) {
              break label539;
            }
            i = localatau.jdField_b_of_type_Int * j / localatau.jdField_a_of_type_Int;
            paramasyu = (asyu)localObject;
            break label195;
            if ((((FrameLayout.LayoutParams)localObject).width != j) || (((FrameLayout.LayoutParams)localObject).height != i))
            {
              ((FrameLayout.LayoutParams)localObject).width = j;
              ((FrameLayout.LayoutParams)localObject).height = i;
              localatal.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
              continue;
              paramasyu = URLDrawable.getDrawable(paramasyu, (URLDrawable.URLDrawableOptions)localObject);
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
 * Qualified Name:     atak
 * JD-Core Version:    0.7.0.1
 */