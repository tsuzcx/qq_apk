package com.tencent.biz.qqstory.utils.ffmpeg;

abstract interface Argument
{
  public static final String AUDIOBITSTREAMFILTER = "-absf";
  public static final String AUDIOCODEC = "-acodec";
  public static final String BITRATE_AUDIO = "-b:a";
  public static final String BITRATE_VIDEO = "-b:v";
  public static final String CHANNELS_AUDIO = "-ac";
  public static final String CONCAT = "concat";
  public static final String COPY = "copy";
  public static final String DURATION = "-t";
  public static final String FILE_INPUT = "-i";
  public static final String FILTER_COMPLEX = "-filter_complex";
  public static final String FORMAT = "-f";
  public static final String FRAMERATE = "-r";
  public static final String FREQ_AUDIO = "-ar";
  public static final String SIZE = "-s";
  public static final String STARTTIME = "-ss";
  public static final String THREADS = "-threads";
  public static final String VERBOSITY = "-v";
  public static final String VERSION = "-version";
  public static final String VIDEOBITSTREAMFILTER = "-vbsf";
  public static final String VIDEOCODEC = "-vcodec";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.Argument
 * JD-Core Version:    0.7.0.1
 */