import cooperation.vip.jsoninflate.model.AlumBasicData;

public class aogm
{
  public static final int FOOTER_TYPE_LOADING = 0;
  public static final int FOOTER_TYPE_LOAD_FAIL = 1;
  public static final int FOOTER_TYPE_LOAD_OVER = 2;
  public static final int TYPE_EMTPY = 2;
  public static final int TYPE_FEED = 0;
  public static final int TYPE_FEED_ADV = 4;
  public static final int TYPE_FEED_BANNER = 6;
  public static final int TYPE_FOOTER = 1;
  public static final int TYPE_MATCH = 3;
  public static final int TYPE_MINI_RECOMM = 5;
  public boolean mAddFriendVerified;
  public AlumBasicData mAlumbasicdata;
  public int mAvailLikeCount;
  public boolean mBigVipHide;
  public int mBigVipLevel;
  public String mDeclaration;
  public int mFooterType;
  public int mGender;
  public boolean mIsMyFeed;
  public boolean mLiked;
  public String mNickName;
  public int mPopularity;
  public String mStrRecomTrace;
  public int mTemplateId;
  public int mType;
  public String mUin;
  public boolean mVipHide;
  public int mVipLevel;
  public int mVipType;
  public int mVoiceDuration;
  public String mVoiceUrl;
  public boolean mbAllowStrangerVote;
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof aogm)) && (bbbr.a(((aogm)paramObject).mUin, this.mUin));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aogm
 * JD-Core Version:    0.7.0.1
 */