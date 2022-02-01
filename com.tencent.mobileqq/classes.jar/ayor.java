import QQService.EVIPSPEC;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.pb.profilecard.VaProfileGate.CommTaskInfo;
import com.tencent.pb.profilecard.VipMusicBox.GetProfileMusicBoxInfoRsp;
import com.tencent.pb.profilecard.VipMusicBox.ProfileMusicInfo;
import com.tencent.pb.profilecard.VipMusicBox.ProfileSingerInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableImageView;

public class ayor
  implements View.OnClickListener, ayou
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ayos jdField_a_of_type_Ayos;
  private SongInfo jdField_a_of_type_ComTencentMobileqqMusicSongInfo = new SongInfo();
  private AlphaClickableImageView jdField_a_of_type_ComTencentWidgetAlphaClickableImageView;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e = true;
  
  public ayor(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public static void a(VaProfileGate.CommTaskInfo paramCommTaskInfo, Card paramCard)
  {
    int k = 1;
    int j = 1;
    VipMusicBox.GetProfileMusicBoxInfoRsp localGetProfileMusicBoxInfoRsp = new VipMusicBox.GetProfileMusicBoxInfoRsp();
    for (;;)
    {
      try
      {
        localGetProfileMusicBoxInfoRsp.mergeFrom(paramCommTaskInfo.bytes_task_data.get().toByteArray());
        paramCard.coverUrl = localGetProfileMusicBoxInfoRsp.music.pic.get();
        paramCommTaskInfo = new StringBuilder();
        i = 0;
        if (i < localGetProfileMusicBoxInfoRsp.music.singer_list.size())
        {
          if (i != 0) {
            paramCommTaskInfo.append("/");
          }
          paramCommTaskInfo.append(((VipMusicBox.ProfileSingerInfo)localGetProfileMusicBoxInfoRsp.music.singer_list.get(i)).singer_name.get());
          i += 1;
          continue;
        }
        paramCard.singer = paramCommTaskInfo.toString();
        paramCard.songId = localGetProfileMusicBoxInfoRsp.music.song_id.get();
        paramCard.songName = localGetProfileMusicBoxInfoRsp.music.song_name.get();
        paramCard.songDuration = localGetProfileMusicBoxInfoRsp.music.duration.get();
        if (QLog.isColorLevel()) {
          QLog.e("ProfileMusicBox", 2, "card songId :" + paramCard.songId + " " + paramCard.songName);
        }
        paramCommTaskInfo = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (paramCommTaskInfo == null) {
          break label336;
        }
        if (paramCommTaskInfo.getAccount().equalsIgnoreCase(paramCard.uin))
        {
          if (!a()) {
            break label337;
          }
          i = j;
          if (TextUtils.isEmpty(paramCard.songId)) {
            i = 2;
          }
          bcef.b(null, "dc00898", "", "", "qq_vip", "0X800A7D6", i, 0, "", "", "", "");
          return;
        }
        paramCommTaskInfo = paramCard.uin;
        if (a())
        {
          i = k;
          bcef.b(null, "dc00898", "", paramCommTaskInfo, "qq_vip", "0X800A7DC", i, 0, "", "", "", "");
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramCommTaskInfo)
      {
        paramCommTaskInfo.printStackTrace();
        return;
      }
      int i = 2;
      continue;
      label336:
      return;
      label337:
      i = 3;
    }
  }
  
  public static boolean a()
  {
    return (VipUtils.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime())) || (VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()));
  }
  
  public static boolean a(aymg paramaymg)
  {
    boolean bool1 = true;
    if (paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard == null) {}
    label74:
    boolean bool2;
    do
    {
      return false;
      if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        int i;
        if (paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.switch_musicbox == 0)
        {
          i = 1;
          bcef.b(null, "dc00898", "", "", "0X800A7DB", "qq_vip", i, 0, "", "", "", "");
          if (paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.switch_musicbox != 0) {
            break label74;
          }
        }
        for (;;)
        {
          return bool1;
          i = 2;
          break;
          bool1 = false;
        }
      }
      bool1 = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
      bool2 = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.isVipOpen(EVIPSPEC.E_SP_BIGCLUB);
    } while ((paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.switch_musicbox != 0) || (TextUtils.isEmpty(paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.songId)) || ((!bool1) && (!bool2)));
    return true;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    paramString = bjnd.a(aqhq.a().jdField_b_of_type_JavaLangString, "uin", paramString);
    localIntent.setFlags(268435456);
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public View a(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131561984, null);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    if (this.c)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131368681).setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377740).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView = ((AlphaClickableImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377740));
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377611).setVisibility(8);
    }
    for (;;)
    {
      a(2);
      this.jdField_a_of_type_Int = AIOUtils.dp2px(35.0F, paramContext.getResources());
      if (this.jdField_a_of_type_Ayos == null) {
        this.jdField_a_of_type_Ayos = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
      }
      this.jdField_a_of_type_Ayos.a(this);
      return this.jdField_a_of_type_AndroidViewView;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377611).setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131368681).setVisibility(8);
    }
  }
  
  public void a()
  {
    if ((this.d) && (!this.c)) {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377611).setVisibility(8);
    }
  }
  
  @SuppressLint({"NewApi"})
  public void a(int paramInt)
  {
    if (this.c)
    {
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setImageResource(2130844691);
        this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setContentDescription("暂停音乐");
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setImageResource(2130844692);
      this.jdField_a_of_type_ComTencentWidgetAlphaClickableImageView.setContentDescription("播放音乐");
      return;
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377611);
    localTextView.setCompoundDrawablePadding(ViewUtils.dpToPx(4.0F));
    if (paramInt == 1)
    {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2130850193, 0, 0, 0);
      return;
    }
    localTextView.setCompoundDrawablesWithIntrinsicBounds(2130850194, 0, 0, 0);
  }
  
  public void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", bjnd.a(aqhq.a().jdField_a_of_type_JavaLangString, "uin", paramString));
    paramContext.startActivity(localIntent);
    int i = 2;
    if (a()) {
      if (!this.d) {}
    }
    for (;;)
    {
      bcef.b(null, "dc00898", "", "", "qq_vip", "0X800A7D7", i, 0, "", "", "", "");
      return;
      i = 1;
      continue;
      i = 3;
    }
  }
  
  public void a(aymg paramaymg)
  {
    Object localObject = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard;
    boolean bool1 = ((Card)localObject).isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
    boolean bool2 = ((Card)localObject).isVipOpen(EVIPSPEC.E_SP_BIGCLUB);
    if ((bool1) || (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      if (!TextUtils.isEmpty(((Card)localObject).songId)) {
        break;
      }
      a(true);
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378524);
      if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)
      {
        this.e = false;
        ((TextView)localObject).setText(ProfileCardMoreInfoView.a(paramaymg) + ((TextView)localObject).getContext().getResources().getString(2131694712));
      }
      return;
    }
    a(false);
    SongInfo localSongInfo = QQPlayerService.b();
    if ((localSongInfo != null) && (localSongInfo.jdField_b_of_type_Long == Long.parseLong(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo = localSongInfo;
      a(QQPlayerService.a());
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo, ayos.a(Long.parseLong(this.jdField_a_of_type_JavaLangString)));
      break;
      this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.c = ((Card)localObject).songName;
      this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.e = ((Card)localObject).coverUrl;
      this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.h = ((Card)localObject).singer;
      this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.g = ((Card)localObject).songId;
      this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_Int = 10;
      this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_Long = Long.parseLong(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(SongInfo paramSongInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ProfileMusicBox", 2, "update :" + paramSongInfo.c);
    }
    if (paramSongInfo.jdField_b_of_type_Long != Long.parseLong(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo = paramSongInfo;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.c)
    {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377610)).setText(paramSongInfo.c);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377609)).setText(paramSongInfo.h);
      a(paramSongInfo.e);
      return;
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377611)).setText(paramSongInfo.c + "-" + paramSongInfo.h);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      a(i);
      return;
    }
  }
  
  public void a(String paramString)
  {
    int i = 1;
    if (this.jdField_b_of_type_JavaLangString.equals(paramString)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130844690);
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130844690);
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(new int[] { this.jdField_a_of_type_Int / 2 });
    paramString.setDecodeHandler(bfol.A);
    paramString.startDownload();
    this.jdField_a_of_type_AndroidViewView.findViewById(2131377740).setBackgroundDrawable(paramString);
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      a(i);
      return;
      i = 2;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (!this.c)
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377611);
      if (paramBoolean)
      {
        localTextView.setVisibility(8);
        return;
      }
      localTextView.setVisibility(0);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131366072).setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377740).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131371520).setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.findViewById(2131366072).setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131377740).setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131371520).setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    a();
    if (this.d) {
      a(paramView.getContext(), this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131364924: 
      case 2131372996: 
        if (this.e) {
          a(paramView.getContext(), this.jdField_a_of_type_JavaLangString);
        } else {
          b(paramView.getContext(), this.jdField_a_of_type_JavaLangString);
        }
        break;
      case 2131368681: 
        b(paramView.getContext(), this.jdField_a_of_type_JavaLangString);
        break;
      case 2131377611: 
      case 2131377740: 
        if (this.e)
        {
          bcef.b(null, "dc00898", "", "", "qq_vip", "0X800A7D8", 0, 0, "", "", "", "");
          if ((!this.jdField_b_of_type_Boolean) && (this.e)) {
            a(paramView.getContext(), this.jdField_a_of_type_JavaLangString);
          }
        }
        else
        {
          String str = this.jdField_a_of_type_JavaLangString;
          if (a()) {}
          for (int i = 1;; i = 2)
          {
            bcef.b(null, "dc00898", "", str, "qq_vip", "0X800A7DD", i, 0, "", "", "", "");
            break;
          }
        }
        if (ayos.a(Long.parseLong(this.jdField_a_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_Ayos.k();
          a(2);
        }
        else
        {
          this.jdField_a_of_type_Ayos.a(Long.parseLong(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayor
 * JD-Core Version:    0.7.0.1
 */